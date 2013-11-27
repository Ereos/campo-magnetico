package com.example.campomagnetico;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter_Tabla_Apar1 extends Adapter_Tabla{

	public Adapter_Tabla_Apar1(Activity activity, double[][] listaValores) {
		super(activity, listaValores);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (convertView==null){
			LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.lista_valores_ap1, null);
			
			holder= new ViewHolder();
			holder.tvColumA = (TextView)view.findViewById(R.id.tvColumA_1);
			holder.tvColumB = (TextView)view.findViewById(R.id.tvColumB_1);
			holder.tvColumC = (TextView)view.findViewById(R.id.tvColumC_1);
			
			view.setTag(holder);
			
		}else {
			holder = (ViewHolder)view.getTag();
		}
		
		holder.tvColumA.setText(listaValores[position][0]+"");
		holder.tvColumB.setText(listaValores[position][1]+"");
		holder.tvColumC.setText("prueba");
		
		return view;
	}
	
	
	private class ViewHolder {
		TextView tvColumA;
		TextView tvColumB;
		TextView tvColumC;
	}

}
