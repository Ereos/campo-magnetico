package com.example.campomagnetico;


import com.example.campomagnetico.R;
import com.example.campomagnetico.R.id;
import com.example.campomagnetico.R.layout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_Tabla extends BaseAdapter {
	Activity activity;
	String[][] listaValores;

	public Adapter_Tabla(Activity activity, String[][] listaValores) {
		super();
		this.activity = activity;
		this.listaValores = listaValores;
	}

	public int getCount() {
		int tamano = 0;
		
		tamano = listaValores[1].length;
		
		return tamano;
	}

	public Object getItem(int position) {
		return listaValores[1][position];
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (convertView==null){
			LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.lista_componentes, null);
			
			holder= new ViewHolder();
			holder.tvColumA = (TextView)view.findViewById(R.id.tvColumA);
			holder.tvColumB = (TextView)view.findViewById(R.id.tvColumB);
			
			view.setTag(holder);
			
		}else {
			holder = (ViewHolder)view.getTag();
		}
		
		holder.tvColumA.setText(listaValores[1][position]);
		holder.tvColumB.setText(listaValores[2][position]);
		
		
		return view;
	}
	
	private class ViewHolder {
		TextView tvColumA;
		TextView tvColumB;	
	}
}
