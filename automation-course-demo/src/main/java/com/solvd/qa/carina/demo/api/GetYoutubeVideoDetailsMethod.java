package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/videos?part=snippet&part=contentDetails&part=statistics", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetYoutubeVideoDetailsMethod extends AbstractApiMethodV2 {

    public GetYoutubeVideoDetailsMethod (String videoId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("yt_url"));
        addUrlParameter("id", videoId);
        addUrlParameter("key", Configuration.getRequired("yt_key"));
        System.out.println(this.request);
    }
}
