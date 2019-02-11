package skd.app.androidfeatures.utils;


/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public final class DownloadUtils {

    String fileName;
    String fileUrl;
    Context mContext;

    File root = android.os.Environment.getExternalStorageDirectory();
    File downloadDir = new File(root.getAbsolutePath() + "/androidfeatures/"); //it is my root directory
    ProgressDialog progress;
    final int totalProgressTime = 100;

    /**
     * This method will start downloading the file
     */
    public void startDownload() {
        progress.show();
        Log.wtf("SKDINFO", "Download started");
        //setup the dirs
        final File tmpFile = new File(downloadDir.getAbsolutePath() + "/" + fileName);
        if (downloadDir.exists() == false) {
            downloadDir.mkdirs();
            Log.wtf("SKDINFO", "folder created");
        }

        //setup the request
        final Request request = new Request.Builder()
                .url(fileUrl)
                .build();

        //setup the progressListner
        final ProgressListener progressListener = new ProgressListener() {
            boolean firstUpdate = true;

            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
                if (done) {
                    Log.wtf("SKDINFO", "Download Complete");

                } else {

                    if (firstUpdate) {
                        firstUpdate = false;
                        if (contentLength == -1) {
                            Log.wtf("SKDINFO", "content-length: unknown");
                        } else {
                            Log.wtf("SKDINFO", "content-length: " + contentLength);
                        }
                    }


                    if (contentLength != -1) {
                        Log.wtf("SKDINFO", "" + (100 * bytesRead) / contentLength);
                        progress.setProgress((int) ((100 * bytesRead) / contentLength));
                    }
                }
            }
        };


        //init okHttp client
        final OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        return originalResponse.newBuilder()
                                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                                .build();
                    }
                })
                .build();

        //send the request and write the file

        Log.wtf("SKDINFO", "Download Starting");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();

                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    //download Success now
                    Log.wtf("SKDINFO", "Download Completed");
                    FileUtils.copyInputStreamToFile(response.body().byteStream(), tmpFile);
                    response.close(); //close reponse to avoid memory leak
                    progress.dismiss();
                    downloadSuccess();
                } catch (Exception e) {
                    e.printStackTrace();
                    progress.dismiss();
                        downloadFail();
                }

            }
        }).start();


    }

    public DownloadUtils(Context context, String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.mContext = context;
        progress = new ProgressDialog(context);
        progress.setMessage("Downloading form ");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setCancelable(false);

        Log.wtf("SKDINFO", "DownloadUtils" + fileName);

    }

    /**
     * custom response body
     */
    private static class ProgressResponseBody extends ResponseBody {

        private final ResponseBody responseBody;
        private final ProgressListener progressListener;
        private BufferedSource bufferedSource;

        ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return responseBody.contentLength();
        }

        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()));
            }
            return bufferedSource;
        }


        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0L;

                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
                    // read() returns the number of bytes read, or -1 if this source is exhausted.
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                    progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                    return bytesRead;
                }
            };
        }
    }

    /**
     * Listner
     */
    interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }


    public void downloadSuccess(){
        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext,"download Success",Toast.LENGTH_SHORT).show();

            }
        });    }

    public void downloadFail()
    {
        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext,"download Fail",Toast.LENGTH_SHORT).show();

            }
        });

    }


}