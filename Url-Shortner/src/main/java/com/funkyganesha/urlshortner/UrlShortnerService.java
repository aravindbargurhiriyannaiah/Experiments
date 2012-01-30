package com.funkyganesha.urlshortner;

import java.net.UnknownHostException;

public interface UrlShortnerService {

    String shortenUrl(String url) throws UnknownHostException;

    String getFullUrl(String shorterUrl) throws UnknownHostException;
}
