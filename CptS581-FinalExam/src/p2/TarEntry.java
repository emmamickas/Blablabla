/*
** Authored by Timothy Gerard Endres
** <mailto:time@gjt.org>  <http://www.trustice.com>
** 
** This work has been placed into the public domain.
** You may use this work in any way and for any purpose you wish.
**
** THIS SOFTWARE IS PROVIDED AS-IS WITHOUT WARRANTY OF ANY KIND,
** NOT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY. THE AUTHOR
** OF THIS SOFTWARE, ASSUMES _NO_ RESPONSIBILITY FOR ANY
** CONSEQUENCE RESULTING FROM THE USE, MODIFICATION, OR
** REDISTRIBUTION OF THIS SOFTWARE. 
** 
*/

package p2;

import java.io.*;
import java.util.Date;


/**
 *
 * This class represents an entry in a Tar archive. It consists
 * of the entry's header, as well as the entry's File. Entries
 * can be instantiated in one of three ways, depending on how
 * they are to be used.
 * <p>
 * TarEntries that are created from the header bytes read from
 * an archive are instantiated with the TarEntry( byte[] )
 * constructor. These entries will be used when extracting from
 * or listing the contents of an archive. These entries have their
 * header filled in using the header bytes. They also set the File
 * to null, since they reference an archive entry not a file.
 * <p>
 * TarEntries that are created from Files that are to be written
 * into an archive are instantiated with the TarEntry( File )
 * constructor. These entries have their header filled in using
 * the File's information. They also keep a reference to the File
 * for convenience when writing entries.
 * <p>
 * Finally, TarEntries can be constructed from nothing but a name.
 * This allows the programmer to construct the entry by hand, for
 * instance when only an InputStream is available for writing to
 * the archive, and the header information is constructed from
 * other information. In this case the header fields are set to
 * defaults and the File is set to null.
 *
 * <p>
 * The C structure for a Tar Entry's header is:
 * <pre>
 * struct header {
 *		char	name[NAMSIZ];
 *		char	mode[8];
 *		char	uid[8];
 *		char	gid[8];
 *		char	size[12];
 *		char	mtime[12];
 *		char	chksum[8];
 *		char	linkflag;
 *		char	linkname[NAMSIZ];
 *		char	magic[8];
 *		char	uname[TUNMLEN];
 *		char	gname[TGNMLEN];
 *		char	devmajor[8];
 *		char	devminor[8];
 *	} header;
 * </pre>
 *
 * @see TarHeader
 *
 */

public
class		TarEntry
	{
	/**
	 * If this entry represents a File, this references it.
	 */
	protected File				file;

	/**
	 * This is the entry's header information.
	 */
	protected TarHeader			header;

	/**
	 * Construct an entry with only a name. This allows the programmer
	 * to construct the entry's header "by hand". File is set to null.
	 */
	public
	TarEntry( String name )
		{
		this.initialize();
		this.header.nameTarHeader( name );
		}

	/**
	 * Construct an entry for a file. File is set to file, and the
	 * header is constructed from information from the file.
	 *
	 * @param file The file that the entry represents.
	 */
	public
	TarEntry( File file )
		throws InvalidHeaderException
		{
		this.initialize();
		this.getFileTarHeader( this.header, file );
		}

	/**
	 * Construct an entry from an archive's header bytes. File is set
	 * to null.
	 *
	 * @param headerBuf The header bytes from a tar archive entry.
	 */
	public
	TarEntry( byte[] headerBuf )
		throws InvalidHeaderException
		{
		this.initialize();
		this.header.parseTarHeader( headerBuf );
		}

	/**
	 * Initialization code common to all constructors.
	 */
	private void
	initialize()
		{
		this.file = null;
		this.header = new TarHeader();
		}

	/**
	 * Determine if the two entries are equal. Equality is determined
	 * by the header names being equal.
	 *
	 * @return it Entry to be checked for equality.
	 * @return True if the entries are equal.
	 */
	public boolean
	tarEntryEquals( TarEntry it )
		{
		return
			this.header.getName().equals( it.header.getName() );
		}

	/**
	 * Determine if the given entry is a descendant of this entry.
	 * Descendancy is determined by the name of the descendant
	 * starting with this entry's name.
	 *
	 * @param desc Entry to be checked as a descendent of this.
	 * @return True if entry is a descendant of this.
	 */
	public boolean
	isDescendent( TarEntry desc )
		{
		return
			desc.header.getName().startsWith( this.header.getName() );
		}

	/**
	 * Get this entry's header.
	 *
	 * @return This entry's TarHeader.
	 */
	public TarHeader
	getHeader()
		{
		return this.header;
		}

	/**
	 * Set this entry's modification time. The parameter passed
	 * to this method is in "Java time".
	 *
	 * @param time This entry's new modification time.
	 */
	public void
	setModTime( long time )
		{
		this.header.setModTime(time / 1000);
		}

	/**
	 * Set this entry's modification time.
	 *
	 * @param time This entry's new modification time.
	 */
	public void
	setModTime( Date time )
		{
		this.header.setModTime(time.getTime() / 1000);
		}

	/**
	 * Get this entry's file.
	 *
	 * @return This entry's file.
	 */
	public File
	getFile()
		{
		return this.file;
		}

	/**
	 * Return whether or not this entry represents a directory.
	 *
	 * @return True if this entry is a directory.
	 */
	public boolean
	isDirectory()
		{
		if ( this.file != null )
			return this.file.isDirectory();

		if ( this.header != null )
			return this.header.isDirectory();

		return false;
		}

	/**
	 * Fill in a TarHeader with information from a File.
	 *
	 * @param hdr The TarHeader to fill in.
	 * @param file The file from which to get the header information.
	 */
	public void
	getFileTarHeader( TarHeader hdr, File file )
		throws InvalidHeaderException
		{
		this.file = file;

		hdr.getFileTarHeader(file);
		}

	/**
	 * If this entry represents a file, and the file is a directory, return
	 * an array of TarEntries for this entry's children.
	 *
	 * @return An array of TarEntry's for this entry's children.
	 */
	public TarEntry[]
	getDirectoryEntries()
		throws InvalidHeaderException
		{
		if ( this.file == null
				|| ! this.file.isDirectory() )
			{
			return new TarEntry[0];
			}

		String[] list = this.file.list();

		TarEntry[] result = new TarEntry[ list.length ];

		for ( int i = 0 ; i < list.length ; ++i )
			{
			result[i] =
				new TarEntry( new File( this.file, list[i] ) );
			}

		return result;
		}

	}

