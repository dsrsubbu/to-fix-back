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


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPtysSubGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPartyAltIDs;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixContextParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRiskLimits;

public class FixPartyDetail implements FixComponent
{

	public byte[] partyID;
	public byte partyIDSource = (byte)' ';
	public long partyRole = 0;
	public FixPtysSubGrp ptysSubGrp;
	public FixPartyAltIDs partyAltIDs;
	public FixContextParties contextParties;
	public FixRiskLimits riskLimits;

	public FixPartyDetail() {
		super();

		partyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		ptysSubGrp = new FixPtysSubGrp();
		partyAltIDs = new FixPartyAltIDs();
		contextParties = new FixContextParties();
		riskLimits = new FixRiskLimits();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( partyID, (byte)0 );
		partyIDSource = Byte.MAX_VALUE;		
		partyRole = Long.MAX_VALUE;		
		ptysSubGrp.clear();
		partyAltIDs.clear();
		contextParties.clear();
		riskLimits.clear();
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.PARTYID_INT:
				partyID = FixUtils.getTagStringValue(null ,id ,value, partyID);
				break;

			case FixTags.PARTYIDSOURCE_INT:
				partyIDSource = FixUtils.getTagCharValue(null ,id ,value );
				if (!PartyIDSource.isValid(partyIDSource) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + partyIDSource + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PARTYROLE_INT:
				partyRole = FixUtils.getTagIntValue(null ,id ,value );
				if (!PartyRole.isValid(partyRole) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + partyRole + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.NOPARTYSUBIDS_INT:
				ptysSubGrp.noPartySubIDs = FixUtils.getTagIntValue(null, FixTags.NOPARTYSUBIDS_INT, value );
				ptysSubGrp.getAll(ptysSubGrp.noPartySubIDs, value );
				break;

			case FixTags.NOPARTYALTIDS_INT:
				partyAltIDs.noPartyAltIDs = FixUtils.getTagIntValue(null, FixTags.NOPARTYALTIDS_INT, value );
				partyAltIDs.getAll(partyAltIDs.noPartyAltIDs, value );
				break;

			case FixTags.NOCONTEXTPARTYIDS_INT:
				contextParties.noContextPartyIDs = FixUtils.getTagIntValue(null, FixTags.NOCONTEXTPARTYIDS_INT, value );
				contextParties.getAll(contextParties.noContextPartyIDs, value );
				break;

			case FixTags.NORISKLIMITS_INT:
				riskLimits.noRiskLimits = FixUtils.getTagIntValue(null, FixTags.NORISKLIMITS_INT, value );
				riskLimits.getAll(riskLimits.noRiskLimits, value );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) >= 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(partyID) ) return FixTags.PARTYID_INT;
		if (! FixUtils.isSet(partyIDSource) ) return FixTags.PARTYIDSOURCE_INT;
		if (! FixUtils.isSet(partyRole) ) return FixTags.PARTYROLE_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) return true;
		if (FixUtils.isSet(partyAltIDs.noPartyAltIDs)) return true;
		if (FixUtils.isSet(contextParties.noContextPartyIDs)) return true;
		if (FixUtils.isSet(riskLimits.noRiskLimits)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.PARTYID_INT, partyID, 0, Utils.lastIndexTrim(partyID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.PARTYIDSOURCE_INT, partyIDSource );
		FixUtils.putFixTag( out, FixTags.PARTYROLE_INT, partyRole);
		if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) ptysSubGrp.encode( out );
		if (FixUtils.isSet(partyAltIDs.noPartyAltIDs)) partyAltIDs.encode( out );
		if (FixUtils.isSet(contextParties.noContextPartyIDs)) contextParties.encode( out );
		if (FixUtils.isSet(riskLimits.noRiskLimits)) riskLimits.encode( out );
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

			 s += "PartyID(448)=" + new String(partyID) + sep;
			 s += "PartyIDSource(447)=" + String.valueOf(partyIDSource) + sep;
			 s += "PartyRole(452)=" + String.valueOf(partyRole) + sep;
			if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) s += ptysSubGrp.toString();
			if (FixUtils.isSet(partyAltIDs.noPartyAltIDs)) s += partyAltIDs.toString();
			if (FixUtils.isSet(contextParties.noContextPartyIDs)) s += contextParties.toString();
			if (FixUtils.isSet(riskLimits.noRiskLimits)) s += riskLimits.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyDetail)) return false;

			FixPartyDetail msg = (FixPartyDetail) o;

		if (!Utils.equals( partyID, msg.partyID)) return false;

		if (!( partyIDSource==msg.partyIDSource)) return false;

		if (!( partyRole==msg.partyRole)) return false;

		if (!ptysSubGrp.equals(msg.ptysSubGrp)) return false;

		if (!partyAltIDs.equals(msg.partyAltIDs)) return false;

		if (!contextParties.equals(msg.contextParties)) return false;

		if (!riskLimits.equals(msg.riskLimits)) return false;

		return true;
	}
}
