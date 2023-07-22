package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.GetYoutubeSearchResultsMethod;
import com.solvd.qa.carina.demo.api.GetYoutubeVideoCommentsMethod;
import com.solvd.qa.carina.demo.api.GetYoutubeVideoDetailsMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class YoutubeCarinaAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testYoutubeSearch() {
        GetYoutubeSearchResultsMethod getYoutubeSearchResultsMethod = new GetYoutubeSearchResultsMethod("Cat Videos");
        getYoutubeSearchResultsMethod.callAPIExpectSuccess();
        getYoutubeSearchResultsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getYoutubeSearchResultsMethod.validateResponseAgainstSchema("api/youtube/yt.schema");
    }

    @Test()
    public void testGetYoutubeVideoById() {
        GetYoutubeSearchResultsMethod getYoutubeSearchResultsMethod = new GetYoutubeSearchResultsMethod("Java Beginners");
        Response searchResponse = getYoutubeSearchResultsMethod.callAPIExpectSuccess();
        String firstVideoId = searchResponse.getBody().jsonPath().get("items[0].id.videoId");

        GetYoutubeVideoDetailsMethod getYoutubeVideoDetailsMethod = new GetYoutubeVideoDetailsMethod(firstVideoId);
        Response videoResponse = getYoutubeVideoDetailsMethod.callAPIExpectSuccess();

        GetYoutubeVideoCommentsMethod getYoutubeVideoCommentsMethod = new GetYoutubeVideoCommentsMethod(firstVideoId);
        Response commentResponse = getYoutubeVideoCommentsMethod.callAPIExpectSuccess();

        String expectedChannelTitle = "Programming with Mosh";
        String actualChannelTitle= videoResponse.jsonPath().get("items[0].snippet.channelTitle");
        Assert.assertEquals(actualChannelTitle, expectedChannelTitle, "The channel names for the first search result differ.");

        String expectedLikeCount = "232694";
        String actualLikeCount = videoResponse.jsonPath().get("items[0].statistics.likeCount");
        Assert.assertEquals(actualLikeCount, expectedLikeCount, "The like count for the first search result differ.");

    }


    @Test
    public void testInvalidParamsForVideoMethod() {
        GetYoutubeVideoDetailsMethod getYoutubeVideoDetailsMethod = new GetYoutubeVideoDetailsMethod("12345");
        Response response = getYoutubeVideoDetailsMethod.callAPIExpectSuccess();

        int actualResults = response.jsonPath().get("pageInfo.totalResults");

        Assert.assertEquals(actualResults, 0, "An invalid video id.");
    }

}
