package com.funkyganesha.urlshortner.dao;

import com.funkyganesha.urlshortner.domain.UrlDetails;
import com.funkyganesha.urlshortner.exception.UrlShortnerException;

public interface UrlDetailsDao {
    /**
     * @param urlDetails
     * @return true if it has been saved, false otherwise.
     */
    boolean save(UrlDetails urlDetails) throws UrlShortnerException;

    /**
     * Delete if available, else ret
     *
     * @param urlDetails
     * @return true if available, false, if unavailable/cannot delete.
     */
    boolean delete(UrlDetails urlDetails) throws UrlShortnerException;


    UrlDetails findByUrl(String url) throws UrlShortnerException;

    UrlDetails findByShortUrl(String shortUrl) throws UrlShortnerException;
}
