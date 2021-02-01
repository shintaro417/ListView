package com.example.listview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listview.R
import com.example.listview.databinding.FragmentListBinding
import java.util.*

class ListFragment : Fragment() {
    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //リストで表示するタイムゾーンの一覧
        val timeZones = TimeZone.getAvailableIDs()
        //リストをレイアウトからバインディングする
        val listView = binding.timeZoneList
        //アダプターを作成
        val adapter = ArrayAdapter<String>(
            requireActivity(),
        R.layout.list_time_zone_row,
        R.id.timeZone,
        timeZones)
        //リストにアダプターをセットする
        listView.adapter = adapter
        //リストのアイテムタップ時の動作
        listView.setOnItemClickListener{parent,view,position,id ->
            //アダプターから、押された位置のタイムゾーンを得る
            val timeZone = adapter.getItem(position)
            //Toastで表示
            Toast.makeText(context,timeZone,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}