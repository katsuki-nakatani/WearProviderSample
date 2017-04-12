package org.gdgkobe.wearsample;

import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;

/**
 * Created by katsuki-nakatani on 2017/04/07.
 */

public class ProviderService extends ComplicationProviderService {
    @Override
    public void onComplicationUpdate(int complicationId, int dataType, ComplicationManager complicationManager) {

        ComplicationData complicationData = null;
        //dataTypeにはWatchFaceから要求されたデータタイプが入ってきます
        //要求されたデータタイプごとに発行するComplicationDataを変えて生成します
        if (dataType == ComplicationData.TYPE_SHORT_TEXT) {
            complicationData =
            new ComplicationData.Builder(ComplicationData.TYPE_SHORT_TEXT)
                    .setShortText(ComplicationText.plainText("短文"))
                    .build();
        } else if (dataType == ComplicationData.TYPE_LONG_TEXT) {
            complicationData =
                    new ComplicationData.Builder(ComplicationData.TYPE_SHORT_TEXT)
                            .setLongTitle(ComplicationText.plainText("長文タイトル"))
                            .setLongText(ComplicationText.plainText("長文です"))
                            .build();
        }
        //complicationManagerにアップデートを送信します
        if (complicationData != null)
            complicationManager.updateComplicationData(complicationId, complicationData);

    }
}
