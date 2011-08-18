package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;

public class FixStrmAsgnReqInstrmtGrp
{

	public int noRelatedSym;
	public StrmAsgnReqInstrmtGrp[] group;

	public void getAll(int noRelatedSym, ByteBuffer buf) throws FixSessionException {
		this.noRelatedSym = noRelatedSym;

		if (noRelatedSym < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRelatedSym) 
			group = new StrmAsgnReqInstrmtGrp[noRelatedSym];

		for ( int i = 0; i < noRelatedSym; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedSym; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedSym; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedSym; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedSym; i++)
			s += group[i].toString();
		return s;
	}

public class StrmAsgnReqInstrmtGrp implements FixComponent
{

	public FixInstrument instrument;
	public byte[] settlType;
	public long mDEntrySize = 0;
	public byte[] mDStreamID;

	public StrmAsgnReqInstrmtGrp() {
		super();

		instrument = new FixInstrument();
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( settlType, (byte)0 );
		mDEntrySize = Long.MAX_VALUE;		
		Utils.fill( mDStreamID, (byte)0 );
		instrument.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLTYPE_INT) {
				settlType = FixUtils.getTagStringValue(value, settlType);
				if (!FixMessageInfo.SettlType.isValid(settlType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + settlType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MDENTRYSIZE_INT) {
				mDEntrySize = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MDSTREAMID_INT) {
				mDStreamID = FixUtils.getTagStringValue(value, mDStreamID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(settlType)) return true;
		if (FixUtils.isSet(mDEntrySize)) return true;
		if (FixUtils.isSet(mDStreamID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(settlType)) FixUtils.putFixTag( out, FixTags.SETTLTYPE_INT, settlType, 0, Utils.lastIndexTrim(settlType, (byte)0) );
		if (FixUtils.isSet(mDEntrySize)) FixUtils.putFixFloatTag( out, FixTags.MDENTRYSIZE_INT, mDEntrySize);
		if (FixUtils.isSet(mDStreamID)) FixUtils.putFixTag( out, FixTags.MDSTREAMID_INT, mDStreamID, 0, Utils.lastIndexTrim(mDStreamID, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(settlType)) s += "SettlType(63)=" + new String(settlType) + sep;
			if (FixUtils.isSet(mDEntrySize)) s += "MDEntrySize(271)=" + String.valueOf(mDEntrySize) + sep;
			if (FixUtils.isSet(mDStreamID)) s += "MDStreamID(1500)=" + new String(mDStreamID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof StrmAsgnReqInstrmtGrp)) return false;

			StrmAsgnReqInstrmtGrp msg = (StrmAsgnReqInstrmtGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!Utils.equals( settlType, msg.settlType)) return false;

		if (!( mDEntrySize==msg.mDEntrySize)) return false;

		if (!Utils.equals( mDStreamID, msg.mDStreamID)) return false;

		return true;
	}
}
}