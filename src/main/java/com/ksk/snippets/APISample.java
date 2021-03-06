/*
package com.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Not a production grade implementation use as an example only
public class APISample {

    public static String BASE_URL = "https://rh-bpm-20171214.workfusion.com/workfusion";
    public static String START_BP_URL = BASE_URL + "/api/v2/workfusion/task/file";
    public static String STATUS_BP_URL = BASE_URL + "/api/v2/workfusion/task/";
    public static String LOGIN_URL = BASE_URL + "/api/dologin";


    public static String UUID = "USE-BUSINESS_PROCESS-DEFINITION-UUID-HERE";
    public static String USERNAME = "YOUR-USERNAME";
    public static String PASSWORD = "YOUR-PASSWORD";

    private HttpClient httpClient;

    public APISample() {
        httpClient = HttpClients.createDefault();
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public String get(String addressURL) throws IOException {

        HttpGet httpGet = new HttpGet(addressURL);
        System.out.println("GET -> " + addressURL);

        HttpResponse response = httpClient.execute(httpGet);
        return convertStreamToString(response.getEntity().getContent());
    }

    public String post(String addressURL, AbstractHttpEntity body) throws IOException {

        HttpPost httpPost = new HttpPost(addressURL);
        System.out.println("POST -> " + addressURL);
        httpPost.setEntity(body);

        HttpResponse response = httpClient.execute(httpPost);
        String stringResponse = convertStreamToString(response.getEntity().getContent());
        System.out.println(stringResponse);

        return stringResponse;
    }

    public void login() throws IOException {

        List<NameValuePair> nvp = new ArrayList<>();
        nvp.add(new BasicNameValuePair("j_username", USERNAME));
        nvp.add(new BasicNameValuePair("j_password", PASSWORD));

        //simply post username and password to the server to login
        //re-use the httpClient instance to make sure same JSESSIONID cookie is used

        //UrlEncodedFormEntity will set Content-Type=application/x-www-form-urlencoded
        post(LOGIN_URL, new UrlEncodedFormEntity(nvp));
    }

    public String startBusinessProcess(String uuid) throws IOException {
        TaskStart taskStart = new TaskStart();
        taskStart.setCampaignUuid(uuid);

        //pass CSV file content here to provide input for a business process
        taskStart.setMainData("loan_amt\n100000");

        StringEntity body = new StringEntity(new Gson().toJson(taskStart));

        //the server may return error if you do not Content-Type=application/json
        body.setContentType("application/json");

        return post(START_BP_URL, body);
    }

    public String getBusinessProcessStatus(String uuid) throws IOException {
        return get(STATUS_BP_URL + uuid);
    }


    public static void main(String... args) throws IOException {
        APISample apiSample = new APISample();
        apiSample.login();

        //get version details and alike
        //apiSample.get(BASE_URL + "/api/v2/workfusion/service/info");

        //launch new business process
        String uuid = apiSample.startBusinessProcess(UUID);

        System.out.println(apiSample.getBusinessProcessStatus(uuid));
    }


    private static class TaskStart implements Serializable {

        @SerializedName("campaignUuid")
        private String campaignUuid;

        @SerializedName("mainData")
        private String mainData;

        @SerializedName("sandbox")
        private Boolean isSandbox;

        @SerializedName("tags")
        private String tags;

        @SerializedName("goldData")
        private String goldData;

        @SerializedName("qualificationRun")
        private Boolean qualificationRun;

        @SerializedName("qualificationTraining")
        private Boolean qualificationTraining;

        public TaskStart() {

        }

        public String getCampaignUuid() {
            return campaignUuid;
        }

        public void setCampaignUuid(String campaignUuid) {
            this.campaignUuid = campaignUuid;
        }

        public String getMainData() {
            return mainData;
        }

        public void setMainData(String mainData) {
            this.mainData = mainData;
        }

        public Boolean isSandbox() {
            return isSandbox;
        }

        public void setSandbox(Boolean sandbox) {
            isSandbox = sandbox;
        }

        public String getTags() {
            return tags;
        }

        public Boolean getSandbox() {
            return isSandbox;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getGoldData() {
            return goldData;
        }

        public void setGoldData(String goldData) {
            this.goldData = goldData;
        }

        public Boolean getQualificationRun() {
            return qualificationRun;
        }

        public void setQualificationRun(Boolean qualificationRun) {
            this.qualificationRun = qualificationRun;
        }

        public Boolean getQualificationTraining() {
            return qualificationTraining;
        }

        public void setQualificationTraining(Boolean qualificationTraining) {
            this.qualificationTraining = qualificationTraining;
        }
    }

}*/
