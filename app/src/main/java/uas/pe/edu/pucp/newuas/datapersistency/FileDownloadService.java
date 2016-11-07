package uas.pe.edu.pucp.newuas.datapersistency;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by samoe on 06/11/2016.
 */

public interface FileDownloadService {
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);
}
