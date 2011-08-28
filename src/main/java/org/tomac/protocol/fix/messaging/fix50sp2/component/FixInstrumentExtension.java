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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixAttrbGrp;

public class FixInstrumentExtension implements FixComponent
{

	public long deliveryForm = 0;
	public long pctAtRisk = 0;
	public FixAttrbGrp attrbGrp;

	public FixInstrumentExtension() {
		super();

		attrbGrp = new FixAttrbGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		deliveryForm = Long.MAX_VALUE;		
		pctAtRisk = Long.MAX_VALUE;		
		attrbGrp.clear();
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.DELIVERYFORM_INT:
				deliveryForm = FixUtils.getTagIntValue(null ,id ,value );
				if (!DeliveryForm.isValid(deliveryForm) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + deliveryForm + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PCTATRISK_INT:
				pctAtRisk = FixUtils.getTagFloatValue(null ,id ,value);
				break;

			case FixTags.NOINSTRATTRIB_INT:
				attrbGrp.noInstrAttrib = FixUtils.getTagIntValue(null, FixTags.NOINSTRATTRIB_INT, value );
				attrbGrp.getAll(attrbGrp.noInstrAttrib, value );
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

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(deliveryForm)) return true;
		if (FixUtils.isSet(pctAtRisk)) return true;
		if (FixUtils.isSet(attrbGrp.noInstrAttrib)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(deliveryForm)) FixUtils.putFixTag( out, FixTags.DELIVERYFORM_INT, deliveryForm);
		if (FixUtils.isSet(pctAtRisk)) FixUtils.putFixFloatTag( out, FixTags.PCTATRISK_INT, pctAtRisk);
		if (FixUtils.isSet(attrbGrp.noInstrAttrib)) attrbGrp.encode( out );
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

			if (FixUtils.isSet(deliveryForm)) s += "DeliveryForm(668)=" + String.valueOf(deliveryForm) + sep;
			if (FixUtils.isSet(pctAtRisk)) s += "PctAtRisk(869)=" + String.valueOf(pctAtRisk) + sep;
			if (FixUtils.isSet(attrbGrp.noInstrAttrib)) s += attrbGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrumentExtension)) return false;

			FixInstrumentExtension msg = (FixInstrumentExtension) o;

		if (!( deliveryForm==msg.deliveryForm)) return false;

		if (!( pctAtRisk==msg.pctAtRisk)) return false;

		if (!attrbGrp.equals(msg.attrbGrp)) return false;

		return true;
	}
}
