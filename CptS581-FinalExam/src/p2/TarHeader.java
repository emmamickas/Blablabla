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

import java.io.File;
import java.util.Date;

/**
 * This class encapsulates the Tar Entry Header used in Tar Archives.
 * The class also holds a number of tar constants, used mostly in headers.
 */

public class
TarHeader
	{
	/**
	 * The length of the name field in a header buffer.
	 */
	public static final int		NAMELEN = 100;
	/**
	 * The length of the mode field in a header buffer.
	 */
	public static final int		MODELEN = 8;
	/**
	 * The length of the user id field in a header buffer.
	 */
	public static final int		UIDLEN = 8;
	/**
	 * The length of the group id field in a header buffer.
	 */
	public static final int		GIDLEN = 8;
	/**
	 * The length of the checksum field in a header buffer.
	 */
	public static final int		CHKSUMLEN = 8;
	/**
	 * The length of the size field in a header buffer.
	 */
	public static final int		SIZELEN = 12;
	/**
	 * The length of the magic field in a header buffer.
	 */
	public static final int		MAGICLEN = 8;
	/**
	 * The length of the modification time field in a header buffer.
	 */
	public static final int		MODTIMELEN = 12;
	/**
	 * The length of the user name field in a header buffer.
	 */
	public static final int		UNAMELEN = 32;
	/**
	 * The length of the group name field in a header buffer.
	 */
	public static final int		GNAMELEN = 32;
	/**
	 * The length of the devices field in a header buffer.
	 */
	public static final int		DEVLEN = 8;

	/**
	 * LF_ constants represent the "link flag" of an entry, or more commonly,
	 * the "entry type". This is the "old way" of indicating a normal file.
	 */
	public static final byte	LF_OLDNORM	= 0;
	/**
	 * Normal file type.
	 */
	public static final byte	LF_NORMAL	= (byte) '0';
	/**
	 * Link file type.
	 */
	public static final byte	LF_LINK		= (byte) '1';
	/**
	 * Symbolic link file type.
	 */
	public static final byte	LF_SYMLINK	= (byte) '2';
	/**
	 * Character device file type.
	 */
	public static final byte	LF_CHR		= (byte) '3';
	/**
	 * Block device file type.
	 */
	public static final byte	LF_BLK		= (byte) '4';
	/**
	 * Directory file type.
	 */
	public static final byte	LF_DIR		= (byte) '5';
	/**
	 * FIFO (pipe) file type.
	 */
	public static final byte	LF_FIFO		= (byte) '6';
	/**
	 * Contiguous file type.
	 */
	public static final byte	LF_CONTIG	= (byte) '7';

	/**
	 * The magic tag representing a POSIX tar archive.
	 */
	public static final String	TMAGIC		= "ustar";

	/**
	 * The magic tag representing a GNU tar archive.
	 */
	public static final String	GNU_TMAGIC	= "ustar  ";

	/**
	 * The entry's name.
	 */
	StringBuilder		name;
	/**
	 * The entry's permission mode.
	 */
	private int				mode;
	/**
	 * The entry's user id.
	 */
	private int				userId;
	/**
	 * The entry's group id.
	 */
	private int				groupId;
	/**
	 * The entry's size.
	 */
	private long				size;
	/**
	 * The entry's modification time.
	 */
	private long				modTime;
	/**
	 * The entry's checksum.
	 */
	private int				checkSum;
	/**
	 * The entry's link flag.
	 */
	private byte				linkFlag;
	/**
	 * The entry's link name.
	 */
	private StringBuilder		linkName;
	/**
	 * The entry's magic tag.
	 */
	private StringBuilder		magic;
	/**
	 * The entry's user name.
	 */
	private StringBuilder		userName;
	/**
	 * The entry's group name.
	 */
	private StringBuilder		groupName;
	/**
	 * The entry's major device number.
	 */
	private int				devMajor;
	/**
	 * The entry's minor device number.
	 */
	private int				devMinor;


	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getModTime() {
		return modTime;
	}

	public void setModTime(long modTime) {
		this.modTime = modTime;
	}

	public int getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}

	public byte getLinkFlag() {
		return linkFlag;
	}

	public void setLinkFlag(byte linkFlag) {
		this.linkFlag = linkFlag;
	}

	public StringBuilder getLinkName() {
		return linkName;
	}

	public void setLinkName(StringBuilder linkName) {
		this.linkName = linkName;
	}

	public StringBuilder getMagic() {
		return magic;
	}

	public void setMagic(StringBuilder magic) {
		this.magic = magic;
	}

	public StringBuilder getUserName() {
		return userName;
	}

	public void setUserName(StringBuilder userName) {
		this.userName = userName;
	}

	public StringBuilder getGroupName() {
		return groupName;
	}

	public void setGroupName(StringBuilder groupName) {
		this.groupName = groupName;
	}

	public int getDevMajor() {
		return devMajor;
	}

	public void setDevMajor(int devMajor) {
		this.devMajor = devMajor;
	}

	public int getDevMinor() {
		return devMinor;
	}

	public void setDevMinor(int devMinor) {
		this.devMinor = devMinor;
	}

	public void setName(StringBuilder name) {
		this.name = name;
	}
	/**
	 * Convenience method to set this entry's group and user ids.
	 *
	 * @param userId This entry's new user id.
	 * @param groupId This entry's new group id.
	 */
	public void
	setIds( int userId, int groupId )
		{
		this.setUserId( userId );
		this.setGroupId( groupId );
		}

	/**
	 * Convenience method to set this entry's group and user names.
	 *
	 * @param userName This entry's new user name.
	 * @param groupName This entry's new group name.
	 */
	public void
	setNames( String userName, String groupName )
		{
		this.setUserName( new StringBuilder(userName) );
		this.setGroupName( new StringBuilder (groupName) );
		}

	public
	TarHeader()
		{
		this.magic = new StringBuilder( TarHeader.TMAGIC );

		this.name = new StringBuilder();
		this.linkName = new StringBuilder();

		String user =
			System.getProperty( "user.name", "" );

		if ( user.length() > 31 )
			user = user.substring( 0, 31 );

		this.userId = 0;
		this.groupId = 0;
		this.userName = new StringBuilder( user );
		this.groupName = new StringBuilder( "" );
		}

	/**
	 * TarHeaders can be cloned.
	 */
	public Object
	clone()
		{
		TarHeader hdr = null;

		try {
			hdr = (TarHeader) super.clone();

			hdr.name =
				(this.name == null ) ? null
					: new StringBuilder( this.name.toString() );
			hdr.mode = this.mode;
			hdr.userId = this.userId;
			hdr.groupId = this.groupId;
			hdr.size = this.size;
			hdr.modTime = this.modTime;
			hdr.checkSum = this.checkSum;
			hdr.linkFlag = this.linkFlag;
			hdr.linkName =
				(this.linkName == null ) ? null
					: new StringBuilder( this.linkName.toString() );
			hdr.magic =
				(this.magic == null ) ? null
					: new StringBuilder( this.magic.toString() );
			hdr.userName =
				(this.userName == null ) ? null
					: new StringBuilder( this.userName.toString() );
			hdr.groupName =
				(this.groupName == null ) ? null
					: new StringBuilder( this.groupName.toString() );
			hdr.devMajor = this.devMajor;
			hdr.devMinor = this.devMinor;
			}
		catch ( CloneNotSupportedException ex )
			{
			ex.printStackTrace();
			}

		return hdr;
		}

	/**
	 * Get the name of this entry.
	 *
	 * @return Teh entry's name.
	 */
	public String
	getName()
		{
		return this.name.toString();
		}
	

	/**
	 * Return whether or not this entry represents a directory.
	 *
	 * @return True if this entry is a directory.
	 */
	public boolean
	isDirectory()
	{
		return this.linkFlag == TarHeader.LF_DIR || this.getName().endsWith( "/" );

	}

	/**
	 * Fill in a TarHeader with information from a File.
	 *
	 * @param hdr The TarHeader to fill in.
	 * @param file The file from which to get the header information.
	 */
	public void getFileTarHeader(File file) {
		String fileName = getFileName(file);

 		this.setLinkName(new StringBuilder( "" ));

 		this.setName(new StringBuilder( fileName ));

		if ( file.isDirectory() )
			{
			this.setMode(040755);
			this.setLinkFlag(TarHeader.LF_DIR);
			if ( this.getName().charAt( this.getName().length() - 1 ) != '/' )
				this.name.append( "/" );
			}
		else
			{
			this.setMode(0100644);
			this.setLinkFlag(TarHeader.LF_NORMAL);
			}

		// UNDONE When File lets us get the userName, use it!

		this.setSize(file.length());
		this.setModTime(file.lastModified() / 1000);
		this.setCheckSum(0);
		this.setDevMajor(0);
		this.setDevMinor(0);
	}

	public String getFileName(File file) {
		String fileName = file.getPath();
		String osname = System.getProperty( "os.name" );
		if ( osname != null )
		{
			// Strip off drive letters!
			// REVIEW Would a better check be "(File.separator == '\')"?

			// Per Patrick Beard:
			String win32Prefix = "windows";
			if ( osname.toLowerCase().startsWith( win32Prefix ) && fileName.length() > 2 )
			{
				char ch1 = fileName.charAt(0);
				char ch2 = fileName.charAt(1);
				if ( ch2 == ':'
					&& ( (ch1 >= 'a' && ch1 <= 'z')
						|| (ch1 >= 'A' && ch1 <= 'Z') ) )
				{
				fileName = fileName.substring( 2 );
				}
			}
		}

		fileName = fileName.replace( File.separatorChar, '/' );

		// No absolute pathnames
		// Windows (and Posix?) paths can start with "\\NetworkDrive\",
		// so we loop on starting /'s.
		
		while (fileName.startsWith( "/" ))
			fileName = fileName.substring( 1 );
		return fileName;
	}
	
	/**
	 * Write an entry's header information to a header buffer.
	 *
	 * @param outbuf The tar entry header buffer to fill in.
	 */
	public void
	writeEntryHeader(byte[] outbuf )
		{
		int offset = getEntryInformationOffset(outbuf);
	
		int csOffset = offset;
		getEntryNameOffset(outbuf, offset);
	
		long fileCheckSum = TarParser.computeCheckSum( outbuf );
	
		TarParser.getCheckSumOctalBytes( fileCheckSum, outbuf, csOffset, TarHeader.CHKSUMLEN );
		}

	public int getEntryInformationOffset(byte[] outbuf) {
		int offset = 0;
	
		offset = TarParser.getNameBytes( name, outbuf, offset, TarHeader.NAMELEN );
	
		offset = TarParser.getOctalBytes( getMode(), outbuf, offset, TarHeader.MODELEN );
	
		offset = TarParser.getOctalBytes( getUserId(), outbuf, offset, TarHeader.UIDLEN );
	
		offset = TarParser.getOctalBytes( getGroupId(), outbuf, offset, TarHeader.GIDLEN );
	
		long thisSize = getSize();
	
		offset = TarParser.getLongOctalBytes( thisSize, outbuf, offset, TarHeader.SIZELEN );
	
		offset = TarParser.getLongOctalBytes( getModTime(), outbuf, offset, TarHeader.MODTIMELEN );
		return offset;
	}

	public void getEntryNameOffset(byte[] outbuf, int offset) {
		for ( int c = 0 ; c < TarHeader.CHKSUMLEN ; ++c )
			outbuf[ offset++ ] = (byte) ' ';
	
		outbuf[ offset++ ] = getLinkFlag();
	
		offset = TarParser.getNameBytes( getLinkName(), outbuf, offset, TarHeader.NAMELEN );
	
		offset = TarParser.getNameBytes( getMagic(), outbuf, offset, TarHeader.MAGICLEN );
	
		offset = TarParser.getNameBytes( getUserName(), outbuf, offset, TarHeader.UNAMELEN );
	
		offset = TarParser.getNameBytes( getGroupName(), outbuf, offset, TarHeader.GNAMELEN );
	
		offset = TarParser.getOctalBytes( getDevMajor(), outbuf, offset, TarHeader.DEVLEN );
	
		offset = TarParser.getOctalBytes( getDevMinor(), outbuf, offset, TarHeader.DEVLEN );
	
		while (offset < outbuf.length)
			outbuf[ offset++ ] = 0;
	}

	/**
	 * Parse an entry's TarHeader information from a header buffer.
	 *
	 * @param header The tar entry header buffer to get information from.
	 */
	public void
	parseTarHeader( byte[] header )
		throws InvalidHeaderException
		{
		int offset = 0;
	
		setName(
				TarParser.parseName( header, offset, TarHeader.NAMELEN ));
	
		offset += TarHeader.NAMELEN;
	
		setMode((int)
				TarParser.parseOctal( header, offset, TarHeader.MODELEN ));
	
		offset += TarHeader.MODELEN;
	
		setUserId((int)
				TarParser.parseOctal( header, offset, TarHeader.UIDLEN ));
	
		offset += TarHeader.UIDLEN;
	
		setGroupId((int)
				TarParser.parseOctal( header, offset, TarHeader.GIDLEN ));
	
		offset += TarHeader.GIDLEN;
	
		setSize(
				TarParser.parseOctal( header, offset, TarHeader.SIZELEN ));
	
		offset += TarHeader.SIZELEN;
	
		setModTime(
				TarParser.parseOctal( header, offset, TarHeader.MODTIMELEN ));
	
		offset += TarHeader.MODTIMELEN;
	
		setCheckSum((int)
				TarParser.parseOctal( header, offset, TarHeader.CHKSUMLEN ));
	
		offset += TarHeader.CHKSUMLEN;
	
		setLinkFlag(header[ offset++ ]);
	
		setLinkName(
			TarParser.parseName( header, offset, TarHeader.NAMELEN ));
	
		offset += TarHeader.NAMELEN;
	
		setMagic(
				TarParser.parseName( header, offset, TarHeader.MAGICLEN ));
	
		offset += TarHeader.MAGICLEN;
	
		setUserName(
				TarParser.parseName( header, offset, TarHeader.UNAMELEN ));
	
		offset += TarHeader.UNAMELEN;
	
		setGroupName(
				TarParser.parseName( header, offset, TarHeader.GNAMELEN ));
	
		offset += TarHeader.GNAMELEN;
	
		setDevMajor((int)
				TarParser.parseOctal( header, offset, TarHeader.DEVLEN ));
	
		offset += TarHeader.DEVLEN;
	
		setDevMinor((int)
				TarParser.parseOctal( header, offset, TarHeader.DEVLEN ));
		}

	/**
	 * Fill in a TarHeader given only the entry's name.
	 *
	 * @param name The tar entry name.
	 */
	public void
	nameTarHeader( String name )
		{
		boolean isDir = name.endsWith( "/" );
	
		setCheckSum(0);
		setDevMajor(0);
		setDevMinor(0);
	
		setName(new StringBuilder( name ));
		setMode(isDir ? 040755 : 0100644);
		setUserId(0);
		setGroupId(0);
		setSize(0);
		setCheckSum(0);
	
		setModTime((new Date()).getTime() / 1000);
	
		setLinkFlag(isDir ? TarHeader.LF_DIR : TarHeader.LF_NORMAL);
	
		setLinkName(new StringBuilder( "" ));
		setUserName(new StringBuilder( "" ));
		setGroupName(new StringBuilder( "" ));
	
		setDevMajor(0);
		setDevMinor(0);
		}

	}
 
