package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/search?part=snippet&maxResults=10&q=${search_term}&type=video&key=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/youtube/search_results.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetYoutubeSearchResultsMethod extends AbstractApiMethodV2 {

    public GetYoutubeSearchResultsMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

    public GetYoutubeSearchResultsMethod(String searchTerm) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("yt_url"));
        replaceUrlPlaceholder("search_term", searchTerm);
        replaceUrlPlaceholder("api_key", Configuration.getRequired("yt_key"));
    }
}

