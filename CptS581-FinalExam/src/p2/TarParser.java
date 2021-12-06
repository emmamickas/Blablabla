package p2;

public class TarParser {

	private TarParser() {
	}

	/**
	 * Compute the checksum of a tar entry header.
	 *
	 * @param buf The tar entry's header buffer.
	 * @return The computed checksum.
	 */
	public static long
	computeCheckSum( byte[] buf )
		{
		long sum = 0;
	
		for ( int i = 0 ; i < buf.length ; ++i )
			{
			sum += 255 & buf[ i ];
			}
	
		return sum;
		}

	/**
	 * Convenience method that will modify an entry's name directly
	 * in place in an entry header buffer byte array.
	 *
	 * @param outbuf The buffer containing the entry header to modify.
	 * @param newName The new name to place into the header buffer.
	 */
	public static void
	adjustEntryName( byte[] outbuf, String newName )
		{
		int offset = 0;
		TarParser.getNameBytes( new StringBuilder( newName ),
				outbuf, offset, TarHeader.NAMELEN );
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
		TarParser.getOctalBytes( value, buf, offset, length );
		buf[ offset + length - 1 ] = (byte) ' ';
		buf[ offset + length - 2 ] = 0;
		return offset + length;
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
		getNameOffset(name, buf, offset, length);

		return offset + length;
		}

	public static void getNameOffset(StringBuilder name, byte[] buf, int offset, int length) {
		int i;

		for ( i = 0 ; i < length && i < name.length() ; ++i )
			{
			buf[ offset + i ] = (byte) name.charAt( i );
			}

		for ( ; i < length ; ++i )
			{
			buf[ offset + i ] = 0;
			}
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
		getOctalOffset(value, buf, offset, length);

		return offset + length;
		}

	public static void getOctalOffset(long value, byte[] buf, int offset, int length) {
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
			for ( long val = value ; idx >= 0 && val > 0 ; --idx, val = val >> 3 )
				{
				buf[ offset + idx ] = (byte)
					( (byte) '0' + (byte) (val & 7) );
				}
			}

		for ( ; idx >= 0 ; --idx )
			{
			buf[ offset + idx ] = (byte) ' ';
			}
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
		TarParser.getOctalBytes( value, temp, 0, length + 1 );
		System.arraycopy( temp, 0, buf, offset, length );
		return offset + length;
		}
}
