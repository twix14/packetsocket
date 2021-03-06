package at.stefl.packetsocket.pdu.formatter;

import at.stefl.packetsocket.io.ExtendedDataInputStream;
import at.stefl.packetsocket.io.ExtendedDataOutputStream;
import at.stefl.packetsocket.pdu.PDU;


public abstract class PDUFormatter {
	
	public byte[] format(PDU pdu) {
		ExtendedDataOutputStream outputStream = new ExtendedDataOutputStream();
		format(pdu, outputStream);
		return outputStream.getData();
	}
	
	public abstract void format(PDU pdu, ExtendedDataOutputStream out);
	
	public PDU parse(byte[] buffer) {
		return parse(new ExtendedDataInputStream(buffer));
	}
	
	public PDU parse(byte[] buffer, int offset, int length) {
		return parse(new ExtendedDataInputStream(buffer, offset, length));
	}
	
	public abstract PDU parse(ExtendedDataInputStream in);
	
}