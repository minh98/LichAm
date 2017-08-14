package com.example.minh98.licham

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {


         fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager,
                                     appWidgetId: Int) {


            //
            val date = Calendar.getInstance()
            val d = date.get(Calendar.DAY_OF_MONTH)
            val m = date.get(Calendar.MONTH) + 1
            val y = date.get(Calendar.YEAR)
            //Toast.makeText(this, d+"/"+m+"/"+y, Toast.LENGTH_SHORT).show();
            val amLich = VietCalendar.minh(d, m, y)
            //lichAm.setText(amLich.get(Calendar.DAY_OF_MONTH)+"/"+amLich.get(Calendar.MONTH)+"/"+amLich.get(Calendar.YEAR));
            val can = amLich.get(Calendar.YEAR) % 10
            val chi = amLich.get(Calendar.YEAR) % 12
            //canChi.setText(getCan(can)+" "+getChi(chi));


            val widgetText = amLich.get(Calendar.DAY_OF_MONTH).toString() + "/" + amLich.get(Calendar.MONTH) + "/" + amLich.get(Calendar.YEAR)
            val canChi = getCan(can) + " " + getChi(chi)

            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.new_app_widget)
            views.setTextViewText(R.id.lichAmwg, widgetText)
            views.setTextViewText(R.id.canChiwg, canChi)

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

        /*private void update() {
        int d=date.get(Calendar.DAY_OF_MONTH);
        int m=date.get(Calendar.MONTH)+1;
        int y=date.get(Calendar.YEAR);
        //Toast.makeText(this, d+"/"+m+"/"+y, Toast.LENGTH_SHORT).show();
        Calendar amLich=VietCalendar.minh(d,m,y);
        lichAm.setText(amLich.get(Calendar.DAY_OF_MONTH)+"/"+amLich.get(Calendar.MONTH)+"/"+amLich.get(Calendar.YEAR));
        int can=(amLich.get(Calendar.YEAR))%10;
        int chi=(amLich.get(Calendar.YEAR))%12;
        canChi.setText(getCan(can)+" "+getChi(chi));
    }*/
         fun getCan(i: Int): String {
            when (i) {
                0 -> return "Canh"
                1 -> return "Tân"
                2 -> return "Nhâm"
                3 -> return "Quý"
                4 -> return "Giáp"
                5 -> return "Ất"
                6 -> return "Bính"
                7 -> return "Đinh"
                8 -> return "Mậu"
                9 -> return "Kỷ"
            }
            return ""
        }

         fun getChi(i: Int): String {
            when (i) {
                0 -> return "Thân"
                1 -> return "Dậu"
                2 -> return "Tuất"
                3 -> return "Hợi"
                4 -> return "Tý"
                5 -> return "Sửu"
                6 -> return "Dần"
                7 -> return "Mão"
                8 -> return "Thìn"
                9 -> return "Tỵ"
                10 -> return "Ngọ"
                11 -> return "Mùi"
            }
            return ""
        }
    }
}

