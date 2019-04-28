package backtraceio.library.interfaces;

import android.os.AsyncTask;

import backtraceio.library.events.OnAfterSendEventListener;
import backtraceio.library.events.OnServerErrorEventListener;
import backtraceio.library.events.OnServerResponseEventListener;
import backtraceio.library.events.RequestHandler;
import backtraceio.library.models.BacktraceData;
import backtraceio.library.models.BacktraceResult;

/**
 * Backtrace API sender interface
 */
public interface IBacktraceApi {

    /**
     * Send a Backtrace report to Backtrace API
     *
     * @param data diagnostic data
     * @return server response
     */
    BacktraceResult send(BacktraceData data);

    void sendWithThreadHandler(BacktraceData data);

    /**
     * Send asynchronous Backtrace report to Backtrace API
     *
     * @param data diagnostic data
     * @return AsyncTask which returns server response after execution
     */
    AsyncTask<Void, Void, BacktraceResult> sendAsync(BacktraceData data);

    void sendUncaughted(BacktraceData data);

    /**
     * Set an event executed when received bad request, unauthorized request or other information
     * from server
     */
    void setOnServerError(OnServerErrorEventListener onServerError);

    /**
     * Set an event executed when server return information after sending data to API
     *
     * @param onServerResponse event which will be executed on server response
     */
    void setOnServerResponse(OnServerResponseEventListener onServerResponse);


    /**
     * Set custom request method to prepare HTTP request to Backtrace API
     *
     * @param requestHandler event which will be executed instead of default request to Backtrace API
     */
    void setRequestHandler(RequestHandler requestHandler);

    /**
     * Set an event executed after sending data to API
     * @param afterSend event which will be executed after sending data to API
     */
    void setAfterSend(OnAfterSendEventListener afterSend);

}