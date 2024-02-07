package pages;

//This page contains locators for all elements to interact with. Android.Findby from page factory can be used alternatively.

public class Locators {
	
	
	//Choose Your Favorite League page locators
    public static final String FAVORITE_PAGE_LABEL_ID = "com.fivemobile.thescore:id/title_onboarding";
    public static final String LEAGUE_NAME_TEXT_VIEW_DYANMIC_XPATH = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name' and @text='%s']";
    
    //Location Access - Tailored Content screen locators
    public static final String LOCATION_ACCESS_ALLOW_BUTTON_ID = "com.fivemobile.thescore:id/btn_allow";
    public static final String LOCATION_ACCESS_DENY_BUTTON_ID = "com.fivemobile.thescore:id/btn_disallow";
    public static final String ALLOW_DEVICE_LOCATION_WHILE_USING_APP_ID = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
    public static final String ALLOW_DEVICE_LOCATION_ONCE_ID = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    public static final String DENY_DEVICE_LOCATION_ID = "com.android.permissioncontroller:id/permission_deny_button";
    
    //Generic locators
    public static final String CONTINUE_OR_DONE_BUTTON_ID = "com.fivemobile.thescore:id/btn_primary";
    public static final String POPUP_CONTAINER_ID = "com.fivemobile.thescore:id/dialog_container";
    public static final String DISMISS_POPUP_ID = "com.fivemobile.thescore:id/dismiss_modal";
    public static final String PAGE_TITILE_ID = "com.fivemobile.thescore:id/titleTextView";
    public static final String BACK_BUTTON_XPATH = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    
    //Favorites Home Screen
    public static final String FAVORITES_HOME_SCREEN_SEARCH_BAR_ID = "com.fivemobile.thescore:id/search_bar_text_view";
    public static final String FAVORITE_TAB_ID = "com.fivemobile.thescore:id/navigation_favorites";
    public static final String LEAGUE_TAB_ID = "com.fivemobile.thescore:id/navigation_leagues";   
    public static final String FAVORITE_LEAGUE_XPATH = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label' and @text='%s']";
    
    //Leagues Screen
    public static final String DISMISS_QTIP_ID = "com.fivemobile.thescore:id/header_right_text_container";
    public static final String LEADERS_TAB_XPATH = "//android.widget.LinearLayout[@content-desc=\"Leaders\"]";
    public static final String STANDINGS_TAB_ID = "//android.widget.LinearLayout[@content-desc=\"Standings\"]";
    public static final String LEADER_NAME_DYNAMIC_TEXT_XPATH = "//android.widget.TextView[@resource-id=\"%s\" and @text=\"%s\"]";
    
    //Player Screen
    public static final String LEADER_PAGE_LEADER_NAME_XPATH = "//android.widget.TextView[@resource-id='%s' and @text='%s']";
    public static final String LEADER_PAGE_INFO_TAB = "//android.widget.LinearLayout[@content-desc=\"Info\"]";
    
    //Standings Screen    
    public static final String STANDINGS_TAB_STATS_NAMES_ID = "com.fivemobile.thescore:id/txt_name";
    
}
