package com.example.campomagnetico;

import java.util.ArrayList;

import com.example.campomagnetico.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Se ha creado un metodo ViewHolder para no tener que buscar cada vez los recursos
 * Adaptadora
 *
 */
public class Adapter_Componentes extends BaseAdapter {
	Activity activity;
	ArrayList<Componente> componente = new ArrayList<Componente>();

	public Adapter_Componentes(Activity activity, ArrayList<Componente> componente) {
		super();
		this.activity = activity;
		this.componente = componente;
	}

	public int getCount() {
		return componente.size();
	}

	public Object getItem(int position) {
		return componente.get(position);
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
			holder.tvNombre = (TextView)view.findViewById(R.id.tvNombre);
			holder.tvDescripcion = (TextView)view.findViewById(R.id.tvDescripcion);
			holder.ivFoto = (ImageView)view.findViewById(R.id.ivImagenComponente);
			
			view.setTag(holder);
			
		}else {
			holder = (ViewHolder)view.getTag();
		}
		
		final Componente item = componente.get(position);
		
		holder.tvNombre.setText(item.getNombre());
		holder.tvDescripcion.setText(item.getDescripcion());
		holder.ivFoto.setImageResource(item.getIdFotoMini());
		
		
		return view;
	}
	
	private class ViewHolder {
		TextView tvNombre;
		TextView tvDescripcion;
		ImageView ivFoto;	
	}
}
