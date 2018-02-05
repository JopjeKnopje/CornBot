package jopjeknopje.bot.cornbot.util;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

public class giphy {

    /**
     * TODO Fix giphy errors fuck me
     */
    public static String getImage(String search) throws GiphyException {
        Giphy giphy = new Giphy(STATICS.GIPHY_API_KEY);
//        SearchFeed feed = giphy.search(search, 1, 0);
//        System.out.println("suc6");
//        return feed.getDataList().get(0).getImages().getOriginal().getUrl();
        return "";
    }
}
