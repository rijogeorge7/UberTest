package com.rijo.ubertest.ui.startUpScreen;

import com.rijo.ubertest.dataRepository.domain.Images;

/**
 * Created by rijogeorge on 10/6/17.
 */

public interface StartupActivityContract {
    interface View {

        void showImagesNotAvailableScreen();

        void showImagesList(Images images);
    }

    interface UserActionListener {
        public void getImages();
    }
}
