package training.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListViewActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

	EditText et;
	Button b;
	ListView lv;
	
	ArrayList<String> arrList = new ArrayList<String>();
	ArrayAdapter<String> arrAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		arrAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, arrList);
		
		et = (EditText)findViewById(R.id.editText1);
		
		b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		
		lv = (ListView)findViewById(R.id.listView1);
		lv.setOnItemClickListener(this);
		lv.setAdapter(arrAdapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		arrList.remove(position);
		arrAdapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		arrList.add(et.getText().toString());
		et.setText("");
		arrAdapter.notifyDataSetChanged();
	}
}
