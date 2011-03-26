package org.tomac.protocol.fix.messaging;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixInMessage;

public class FixMessageListenerImpl implements FixMessageListener 
{

    @Override
    public void onUnknownMessageType( ByteBuffer msg, int msgType ) {}

    @Override
    public void onFixAcceptedCancelReplace( FixAcceptedCancelReplace msg ) {}

    @Override
    public void onFixAcceptedCancel( FixAcceptedCancel msg ) {}

    @Override
    public void onFixApplicationReject( FixApplicationReject msg ) {}

    @Override
    public void onFixBreakNotification( FixBreakNotification msg ) {}

    @Override
    public void onFixBusinessReject( FixBusinessReject msg ) {}

    @Override
    public void onFixCancelNotification( FixCancelNotification msg ) {}

    @Override
    public void onFixEntryNotificationtoAllegedFirm( FixEntryNotificationtoAllegedFirm msg ) {}

    @Override
    public void onFixExecutionReportFill( FixExecutionReportFill msg ) {}

    @Override
    public void onFixExecutionRestatement( FixExecutionRestatement msg ) {}

    @Override
    public void onFixLockedinNotification( FixLockedinNotification msg ) {}

    @Override
    public void onFixLockedinTradeBreak( FixLockedinTradeBreak msg ) {}

    @Override
    public void onFixOrderAcknowledgement( FixOrderAcknowledgement msg ) {}

    @Override
    public void onFixOrderReject( FixOrderReject msg ) {}

    @Override
    public void onFixPendingCancel( FixPendingCancel msg ) {}

    @Override
    public void onFixTradeEntryNotificationtoEnteringFirm( FixTradeEntryNotificationtoEnteringFirm msg ) {}

    @Override
    public void onFixTradeReportCancel( FixTradeReportCancel msg ) {}

    @Override
    public void onFixTradeReportEntry( FixTradeReportEntry msg ) {}

    @Override
    public void onFixHeartbeat( FixHeartbeat msg ) {}

    @Override
    public void onFixLogon( FixLogon msg ) {}

    @Override
    public void onFixLogout( FixLogout msg ) {}

    @Override
    public void onFixOrderSingle( FixOrderSingle msg ) {}

    @Override
    public void onFixOrderCancelReject( FixOrderCancelReject msg ) {}

    @Override
    public void onFixRejectedCancelReplace( FixRejectedCancelReplace msg ) {}

    @Override
    public void onFixOrderCancelReplaceRequest( FixOrderCancelReplaceRequest msg ) {}

    @Override
    public void onFixOrderCancelRequest( FixOrderCancelRequest msg ) {}

    @Override
    public void onFixReject( FixReject msg ) {}

    @Override
    public void onFixResendRequest( FixResendRequest msg ) {}

    @Override
    public void onFixSequenceReset( FixSequenceReset msg ) {}

    @Override
    public void onFixTestRequest( FixTestRequest msg ) {}

}
