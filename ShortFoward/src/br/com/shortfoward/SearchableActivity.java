package br.com.shortfoward;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

public class SearchableActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.search_layout);
	    InputMethodManager inputManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        SearchView search = (SearchView)findViewById(R.id.searchview);
	    search.setIconifiedByDefault(false);
	    search.setQueryHint("Sufixo");
	    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(search, InputMethodManager.SHOW_FORCED);
	    
	    
	    
	    
	}
}
