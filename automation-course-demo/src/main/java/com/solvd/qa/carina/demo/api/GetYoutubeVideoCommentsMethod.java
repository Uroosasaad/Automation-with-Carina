package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/commentThreads?textFormat=plainText&part=snippet&maxResults=1", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetYoutubeVideoCommentsMethod extends AbstractApiMethodV2 {

    public GetYoutubeVideoCommentsMethod(String videoId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("yt_url"));
        addUrlParameter("videoId", videoId);
        addUrlParameter("key", Configuration.getRequired("yt_key"));
    }
}
