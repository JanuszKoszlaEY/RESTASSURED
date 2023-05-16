package com.commonData;

import com.utilities.PropertyManager;

public interface CommonData {
    String URL = PropertyManager.getInstance().getURL();
    String LOG_LEVEL = PropertyManager.getInstance().getLog().toUpperCase();
}
