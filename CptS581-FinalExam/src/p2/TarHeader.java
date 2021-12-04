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

/**
 * This class encapsulates the Tar Entry Header used in Tar Archives.
 * The class also holds a number of tar constants, used mostly in headers.
 */

public class
TarHeader extends Object
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
	 * Parse an octal string from a header buffer. This is used for the
	 * file permission mode value.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The long value of the octal string.
	 */
	public static long
	parseOctal( byte[] header, int offset, int length )
		throws InvalidHeaderException
		{
		long result = 0;
		boolean stillPadding = true;

		int end = offset + length;
		for ( int i = offset ; i < end ; ++i )
			{
			if ( header[i] == 0 )
				break;

			if ( header[i] == (byte) ' ' || header[i] == '0' )
				{
				if ( stillPadding )
					continue;

				if ( header[i] == (byte) ' ' )
					break;
				}
			
			stillPadding = false;

			result =
				(result << 3)
					+ (header[i] - '0');
			}

		return result;
		}

	/**
	 * Parse an entry name from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The header's entry name.
	 */
	public static StringBuilder
	parseName( byte[] header, int offset, int length )
		throws InvalidHeaderException
		{
		StringBuilder result = new StringBuilder( length );

		int end = offset + length;
		for ( int i = offset ; i < end ; ++i )
			{
			if ( header[i] == 0 )
				break;
			result.append( (char)header[i] );
			}

		return result;
		}

	/**
	 * Determine the number of bytes in an entry name.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The number of bytes in a header's entry name.
	 */
	public static int
	getNameBytes( StringBuilder name, byte[] buf, int offset, int length )
		{
		int i;

		for ( i = 0 ; i < length && i < name.length() ; ++i )
			{
			buf[ offset + i ] = (byte) name.charAt( i );
			}

		for ( ; i < length ; ++i )
			{
			buf[ offset + i ] = 0;
			}

		return offset + length;
		}

	/**
	 * Parse an octal integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The integer value of the octal bytes.
	 */
	public static int
	getOctalBytes( long value, byte[] buf, int offset, int length )
		{
		byte[] result = new byte[ length ];

		int idx = length - 1;

		buf[ offset + idx ] = 0;
		--idx;
		buf[ offset + idx ] = (byte) ' ';
		--idx;

		if ( value == 0 )
			{
			buf[ offset + idx ] = (byte) '0';
			--idx;
			}
		else
			{
			for ( long val = value ; idx >= 0 && val > 0 ; --idx )
				{
				buf[ offset + idx ] = (byte)
					( (byte) '0' + (byte) (val & 7) );
				val = val >> 3;
				}
			}

		for ( ; idx >= 0 ; --idx )
			{
			buf[ offset + idx ] = (byte) ' ';
			}

		return offset + length;
		}

	/**
	 * Parse an octal long integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The long value of the octal bytes.
	 */
	public static int
	getLongOctalBytes( long value, byte[] buf, int offset, int length )
		{
		byte[] temp = new byte[ length + 1 ];
		TarHeader.getOctalBytes( value, temp, 0, length + 1 );
		System.arraycopy( temp, 0, buf, offset, length );
		return offset + length;
		}

	/**
	 * Parse the checksum octal integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The integer value of the entry's checksum.
	 */
	public static int
	getCheckSumOctalBytes( long value, byte[] buf, int offset, int length )
		{
		TarHeader.getOctalBytes( value, buf, offset, length );
		buf[ offset + length - 1 ] = (byte) ' ';
		buf[ offset + length - 2 ] = 0;
		return offset + length;
		}

	}
 
