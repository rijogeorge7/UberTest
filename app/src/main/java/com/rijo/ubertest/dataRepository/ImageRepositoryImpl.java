package com.rijo.ubertest.dataRepository;

import com.rijo.ubertest.dataRepository.domain.Images;
import com.rijo.ubertest.util.Utilities;

/**
 * Created by rijogeorge on 10/6/17.
 */

public class ImageRepositoryImpl implements ImageRepository{
    @Override
    public Images getImagesFrom(String flickerBaseUrl) {
        String imagesString= Utilities.downloadProductsFromUrl(flickerBaseUrl);
        if(imagesString!=null) {
            Images images = Utilities.getClassFromJSONString(imagesString, Images.class);
            return images;
        }
        else {
            return null;
        }
    }
}
