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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties;

public class FixApplIDRequestGrp
{

	public int noApplIDs;
	public ApplIDRequestGrp[] group;

	public void getAll(int noApplIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noApplIDs = noApplIDs;

		if (noApplIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noApplIDs ).getBytes(), FixTags.NOAPPLIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noApplIDs) {
			group = new ApplIDRequestGrp[noApplIDs];

			for ( int i = 0; i < noApplIDs; i++ ) group[i] = new ApplIDRequestGrp();
	}

		for ( int i = 0; i < noApplIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noApplIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noApplIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noApplIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixApplIDRequestGrp)) return false;

		FixApplIDRequestGrp msg = (FixApplIDRequestGrp) o;

		for (int i = 0; i<noApplIDs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noApplIDs; i++)
			s += group[i].toString();
		return s;
	}

public class ApplIDRequestGrp implements FixComponent
{

	public byte[] refApplID;
	public byte[] refApplReqID;
	public long applBegSeqNum = 0;
	public long applEndSeqNum = 0;
	public FixNestedParties nestedParties;

	public ApplIDRequestGrp() {
		super();

		refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		refApplReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nestedParties = new FixNestedParties();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( refApplID, (byte)0 );
		Utils.fill( refApplReqID, (byte)0 );
		applBegSeqNum = Long.MAX_VALUE;		
		applEndSeqNum = Long.MAX_VALUE;		
		nestedParties.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.REFAPPLID_INT) {
				refApplID = FixUtils.getTagStringValue(null ,id ,value, refApplID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFAPPLREQID_INT) {
				refApplReqID = FixUtils.getTagStringValue(null ,id ,value, refApplReqID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.APPLBEGSEQNUM_INT) {
				applBegSeqNum = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.APPLENDSEQNUM_INT) {
				applEndSeqNum = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTEDPARTYIDS_INT) {
				int noNestedPartyIDs;
				noNestedPartyIDs = FixUtils.getTagIntValue(null ,id ,value );
				nestedParties.getAll(noNestedPartyIDs, buf);
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
		if (FixUtils.isSet(refApplID)) return true;
		if (FixUtils.isSet(refApplReqID)) return true;
		if (FixUtils.isSet(applBegSeqNum)) return true;
		if (FixUtils.isSet(applEndSeqNum)) return true;
		if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(refApplID)) FixUtils.putFixTag( out, FixTags.REFAPPLID_INT, refApplID, 0, Utils.lastIndexTrim(refApplID, (byte)0) );
		if (FixUtils.isSet(refApplReqID)) FixUtils.putFixTag( out, FixTags.REFAPPLREQID_INT, refApplReqID, 0, Utils.lastIndexTrim(refApplReqID, (byte)0) );
		if (FixUtils.isSet(applBegSeqNum)) FixUtils.putFixTag( out, FixTags.APPLBEGSEQNUM_INT, applBegSeqNum);
		if (FixUtils.isSet(applEndSeqNum)) FixUtils.putFixTag( out, FixTags.APPLENDSEQNUM_INT, applEndSeqNum);
		if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) nestedParties.encode( out );
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

			if (FixUtils.isSet(refApplID)) s += "RefApplID(1355)=" + new String(refApplID) + sep;
			if (FixUtils.isSet(refApplReqID)) s += "RefApplReqID(1433)=" + new String(refApplReqID) + sep;
			if (FixUtils.isSet(applBegSeqNum)) s += "ApplBegSeqNum(1182)=" + String.valueOf(applBegSeqNum) + sep;
			if (FixUtils.isSet(applEndSeqNum)) s += "ApplEndSeqNum(1183)=" + String.valueOf(applEndSeqNum) + sep;
			if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) s += nestedParties.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ApplIDRequestGrp)) return false;

			ApplIDRequestGrp msg = (ApplIDRequestGrp) o;

		if (!Utils.equals( refApplID, msg.refApplID)) return false;

		if (!Utils.equals( refApplReqID, msg.refApplReqID)) return false;

		if (!( applBegSeqNum==msg.applBegSeqNum)) return false;

		if (!( applEndSeqNum==msg.applEndSeqNum)) return false;

		if (!nestedParties.equals(msg.nestedParties)) return false;

		return true;
	}
}
}
