package com.rijo.ubertest.dataRepository;

import com.rijo.ubertest.dataRepository.domain.Images;

/**
 * Created by rijogeorge on 10/6/17.
 */

public interface ImageRepository {
    Images getImagesFrom(String flickerBaseUrl);
}
