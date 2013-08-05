package br.com.shortfoward.widget;



import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import br.com.shortfoward.R;
import br.com.shortfoward.SearchableActivity;

public class ShortFowardWidget extends AppWidgetProvider {
	private static String CLICK_ACTION_SEARCH ="search";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		
		if (intent.getAction().equals(CLICK_ACTION_SEARCH))
		{
			Intent intentShare = new Intent(context,SearchableActivity.class);
			intentShare.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
	        context.startActivity(intentShare);
		}
		
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		intent.setAction(CLICK_ACTION_SEARCH);
		//Toast.makeText(context, R.string.rastreamento_iniciado, Toast.LENGTH_SHORT).show();
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		views.setOnClickPendingIntent(R.id.btn, pendingIntent);
		ComponentName cn = new ComponentName(context, ShortFowardWidget.class);
		AppWidgetManager.getInstance(context).updateAppWidget(cn, views);
		
		
	}
}
