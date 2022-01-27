package com.example.teste.atm.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teste.atm.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoSobre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoSobre extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoSobre() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoSobre.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoSobre newInstance(String param1, String param2) {
        FragmentoSobre fragment = new FragmentoSobre();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragmento_sobre, container, false);

        String descricao = "ATM Consultoria tem como missão apoiar organizaçãoes que desejam alcançar o sucesso através da excelência em gestão e busca pela qualidade";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um email")
                .addWebsite("www.google.com", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("valterkamiji", "Facebook")
                .addInstagram("valterkamiji", "Instagram")
                .addTwitter("valterkamiji", "Twitter")
                .addYoutube("valterkamiji", "YouTube")
                .addGitHub("valterkamiji", "Github")
                .addPlayStore("com.facebook.katana", "Download App")

                .addItem(versao)

                .create();
    }
}