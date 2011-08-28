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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixTrdCollGrp
{

	public int noTrades;
	public TrdCollGrp[] group;

	public void getAll(int noTrades, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noTrades = noTrades;

		if (noTrades < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noTrades ).getBytes(), FixTags.NOTRADES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noTrades) {
			group = new TrdCollGrp[noTrades];

			for ( int i = 0; i < noTrades; i++ ) group[i] = new TrdCollGrp();
	}

		for ( int i = 0; i < noTrades; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTrades; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTrades; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTrades; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdCollGrp)) return false;

		FixTrdCollGrp msg = (FixTrdCollGrp) o;

		for (int i = 0; i<noTrades; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTrades; i++)
			s += group[i].toString();
		return s;
	}

public class TrdCollGrp implements FixComponent
{

	public byte[] tradeReportID;
	public byte[] secondaryTradeReportID;

	public TrdCollGrp() {
		super();

		tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( tradeReportID, (byte)0 );
		Utils.fill( secondaryTradeReportID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.TRADEREPORTID_INT) {
				tradeReportID = FixUtils.getTagStringValue(null ,id ,value, tradeReportID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYTRADEREPORTID_INT) {
				secondaryTradeReportID = FixUtils.getTagStringValue(null ,id ,value, secondaryTradeReportID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		if (FixUtils.isSet(tradeReportID)) return true;
		if (FixUtils.isSet(secondaryTradeReportID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(tradeReportID)) FixUtils.putFixTag( out, FixTags.TRADEREPORTID_INT, tradeReportID, 0, Utils.lastIndexTrim(tradeReportID, (byte)0) );
		if (FixUtils.isSet(secondaryTradeReportID)) FixUtils.putFixTag( out, FixTags.SECONDARYTRADEREPORTID_INT, secondaryTradeReportID, 0, Utils.lastIndexTrim(secondaryTradeReportID, (byte)0) );
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

			if (FixUtils.isSet(tradeReportID)) s += "TradeReportID(571)=" + new String(tradeReportID) + sep;
			if (FixUtils.isSet(secondaryTradeReportID)) s += "SecondaryTradeReportID(818)=" + new String(secondaryTradeReportID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TrdCollGrp)) return false;

			TrdCollGrp msg = (TrdCollGrp) o;

		if (!Utils.equals( tradeReportID, msg.tradeReportID)) return false;

		if (!Utils.equals( secondaryTradeReportID, msg.secondaryTradeReportID)) return false;

		return true;
	}
}
}
