package uas.pe.edu.pucp.newuas.controller;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.datapersistency.FileDownloadService;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;

public class FileDownloadController {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static NotificationManager notificationManager;
    private static NotificationCompat.Builder notificationBuilder;

    private static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    public static void downloadFile(final Context context, final String fileUrlParam) {

        final FileDownloadService downloadService = RetrofitHelper.apiConnector.create(FileDownloadService.class);
        verifyStoragePermissions((Activity) context);
        new AsyncTask<Void, Long, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                Call<ResponseBody> call = downloadService.downloadFileWithDynamicUrlSync(fileUrlParam);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {

                            boolean writtenToDisk = false;
                            try {
                                writtenToDisk = writeResponseBodyToDisk(context, fileUrlParam, response.body());

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Log.d("", "file download was a success? " + writtenToDisk);
                        } else {
                            Log.d("", "server contact failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("", "error");
                    }
                });

                return null;
            }
        }.execute();

    }

    private static boolean writeResponseBodyToDisk(Context context, String fileUrl, ResponseBody body) throws IOException {
        String[] split = fileUrl.split("/");
        String fileName = split[split.length - 1];
        String fileStoragePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + fileName;
        Log.d("write", fileStoragePath);
        File file = new File(fileStoragePath);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            byte[] fileReader = new byte[4096];

            long fileSize = body.contentLength();
            long fileSizeDownloaded = 0;

            inputStream = body.byteStream();
            outputStream = new FileOutputStream(file);
            inicioDescarga(context, fileStoragePath);

            while (true) {
                int read = inputStream.read(fileReader);

                if (read == -1) {
                    break;
                }

                outputStream.write(fileReader, 0, read);

                fileSizeDownloaded += read;
                int progress = (int) ((fileSizeDownloaded * 100) / fileSize);
                notificationBuilder.setProgress(100, progress, false);
                Log.d("", "file download: " + fileSizeDownloaded + " of " + fileSize);
            }
            finDescarga();
            outputStream.flush();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void inicioDescarga(final Context context, String fileStoragePath) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Log.d("inicioDescarga", fileStoragePath);
        Intent intent = getOpenFileIntent(fileStoragePath);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_get_app_white_36dp)
                .setContentTitle("Descargando")
                .setContentText("Descargando...")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        notificationManager.notify(0, notificationBuilder.build());
    }

    private static void finDescarga() {
        notificationManager.cancel(0);
        notificationBuilder.setProgress(0, 0, false);
        notificationBuilder.setContentText("Descarga Completa.");
        notificationManager.notify(0, notificationBuilder.build());

    }

    private static Intent getOpenFileIntent(String path) {
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        Log.d("Intent", path);
        String extension = fileExt(path);
        String type = mime.getMimeTypeFromExtension(extension);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, type);
        return intent;
    }

    private static String fileExt(String path) {
        Log.d("fileExt", path);
        String[] sep = path.split("\\.");
        return sep[sep.length - 1];
    }
}
