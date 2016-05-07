package com.andre.guia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.andre.guia.adapter.CasasAdapter;
import com.andre.guia.entity.CasaEntity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    // private Button buttonLista;
    private List<CasaEntity> casas;
    private RecyclerView listaCasas;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setUI();
        setToolbar(getString(R.string.app_name));
        setCasas();
        setRecyclerView();
    }

    private void setUI() {
        //buttonLista = (Button) findViewById(R.id.buton_Lista);
        casas = new ArrayList<>();
        listaCasas = (RecyclerView) findViewById(R.id.lista_casas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar(String name){
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
    }

    private void setCasas() {
        CasaEntity casa = new CasaEntity();
        casa.setName("Cravi");
        casa.setAddress("Rua José Serrato, Nº 55 - Boa Vista");
        casa.setDescription("A CRAVI atua na Modalidade de Comunidade Terapêutica");
        casa.setTel("(41) 3356 6100");
        casa.setImage(R.drawable.cravi);
        casa.setLat(-25.377484);
        casa.setLng(-49.242441);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Emunah Centro de Habilatacao");
        casa.setAddress("Rua Carlos Belão, 464 - Vila Juliana - Piraquara - PR");
        casa.setDescription("");
        casa.setTel("(41) 3590 0518");
        casa.setImage(R.drawable.emanuah);
        casa.setLat(-25.456100);
        casa.setLng(-49.069330);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("VIVA Clinica Terapeutica");
        casa.setAddress("Rua Sao Sebastiao, 231 - sala 02 e 03, Bairro Ahu - Curitiba/PR");
        casa.setDescription("");
        casa.setTel("(41) 9118 9091");
        casa.setImage(R.drawable.viva);
        casa.setLat(-25.405545);
        casa.setLng(-49.259595);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Clinica Nova Esperanca");
        casa.setAddress("Av. Silva Jardim, 4205 Curitiba PR CEP: 80240-021");
        casa.setDescription("casa de apoio para usarios");
        casa.setTel("(41) 3244 4155");
        casa.setImage(R.drawable.novaesperanca);
        casa.setLat(-25.451949);
        casa.setLng(-49.300083);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Grupo Vale Comunidade teraupetica");
        casa.setAddress("Estrada do Saivá, s/n, km 02° Saivá Antonina - PR ");
        casa.setDescription("");
        casa.setTel("(41) 3432 0905");
        casa.setImage(R.drawable.grupovale);
        casa.setLat(-25.440405);
        casa.setLng(-48.727867);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Núcleo de Integração Pessoal");
        casa.setAddress("Rua Joaquim Duarte Moleirinho 2282 ");
        casa.setDescription("");
        casa.setTel("(44) 3262-0266");
        casa.setImage(R.drawable.nucleodeintegracaopessoal);
        casa.setLat(-23.4430183);
        casa.setLng(-51.9475101);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("CLÍNICA CLEUZA CANAN");
        casa.setAddress("Rua Cândido Xavier, 430 - Batel - Curitiba ");
        casa.setDescription("");
        casa.setTel("(41) 3342-7080");
        casa.setImage(R.drawable.img_bacacheri_park);
        casa.setLat(-25.4502477);
        casa.setLng(-49.2944386);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Quinta Do Sol");
        casa.setAddress("Rua Cel. Francisco H. dos Santos, 1180 - Jardim das Americas - Curitiba ");
        casa.setDescription("");
        casa.setTel("(41) 3267 6969");
        casa.setImage(R.drawable.quintadosol);
        casa.setLat(-25.440405);
        casa.setLng(-48.727867);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Centro de Triagem Fazdi");
        casa.setAddress("Rua Waldemar Loureiro Campos, 3468 - Xaxim - Curitiba ");
        casa.setDescription("Encaminha dependentes químicos e alcoolistas para tratamento em Comunidades Terapêuticas Cristãs e oferece vagas: masculinas, femininas e adolescentes.\n" +
                "Atendimentos: De seg. a sex. das 9:00h às 16:00h.");
        casa.setTel("(41) 3095-3844 / (41) 9659-5993");
        casa.setImage(R.drawable.centrodetriagemfazdi);
        casa.setLat(25.5129334);
        casa.setLng(-49.235599);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Associação Comunidade Vida Nova");
        casa.setAddress("Rua Desembargador Otávio do Amaral, 1929 - Merces - Curitiba ");
        casa.setDescription("Internamento exclusivamente voluntário, tratamento de dependência química (lista de espera), com ênfase em alcoolismo. Dispõe de 28 vagas, homens e mulheres a partir de 20 anos, atendimento particular, vaga social apenas p/ pacientes encaminhados por Paróquias com acompanhamento do religioso responsável.");
        casa.setTel("(41) 3335-8991");
        casa.setImage(R.drawable.vidanova);
        casa.setLat(-25.4203706);
        casa.setLng(-49.3014764);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Associação Solidários pela vida – SOVIDA");
        casa.setAddress("Rua Prof. Benedito Conceição, 1691 - Capão da Imbúia  - Curitiba ");
        casa.setDescription("Internamento de pacientes dependentes químicos portadores do vírus HIV. Dispões de 22 vagas masculinas em situação de vulnerabilidade social e econômica. Possuem convênio com o Sistema Único de Saúde. Oferecem também atendimento terapêutico familiar e domiciliar, exigem contrapartida de permanência de pelo menos uma participação mensal das atividades propostas.\n");
        casa.setTel("(41) 3366-2334");
        casa.setImage(R.drawable.sovida);
        casa.setLat(-25.4416926);
        casa.setLng(-49.2114597);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Associação Reviver – Comunidade Terapêutica encontrei um Amigo");
        casa.setAddress("Rua Francisco Xavier de Almeida Garret, 1468 - Centro - Campo Largo");
        casa.setDescription("Internamento exclusivamente voluntário, dispõe de 16 vagas para mulheres com quadro de dependência química, oferece tratamento psicológico, psiquiátrico, clínico e odontológico.Tempo de internamento de 06 a 09 meses mais 03 meses caso necessário a reinserção social. Recebem pacientes do IASP e Prefeitura Municipal de São Mateus do Sul e comunidade em geral. \n");
        casa.setTel("(41) 3392-4673");
        casa.setImage(R.drawable.associacaoreviver);
        casa.setLat(-25.4681435);
        casa.setLng(-49.5269119);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Casa de Apoio – Associação Padre João Ceconello ");
        casa.setAddress("Rua Sebastião Malucelli, 99 - Novo Mundo - Curitiba");
        casa.setDescription("Dispõe de 90 leitos para atendimento de homens de 18 a 59 anos de idade, o internamento ocorre em regime integral por 09 meses, sendo os três primeiros meses p/ desintoxicação. As visitas ocorrem após 30 dias de internamento, sendo possível contato telefônico com familiares após uma semana de internação. Recebem pacientes encaminhados pela Fundação de Ação Social (FAS), através do Resgate Social, ou seja, população de rua, pessoas sem família e sem condições financeiras, cada caso é avaliado pelo Serviço Social e pela Prefeitura Municipal de São José.");
        casa.setTel("(41) 3248-1414");
        casa.setImage(R.drawable.casadeapoio);
        casa.setLat(-25.4850206);
        casa.setLng(-49.3018407);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Crenvi ");
        casa.setAddress("Rua Amazonas de Souza Azevedo, 508. - Bacacheri - Curitiba");
        casa.setDescription("");
        casa.setTel("(41) 3264-4075 ");
        casa.setImage(R.drawable.crenvi);
        casa.setLat(-25.4098945);
        casa.setLng(-49.2264992);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Casa do Servo Sofredor Monte Carmelo");
        casa.setAddress("Rua La Salle, n 850 - Pinheirinho - Cuiritiba");
        casa.setDescription("Recebem pacientes que já tenham sido desintoxicados, internamento exclusivamente voluntário. Dispõe de 120 vagas divididas em três casas: masculina, feminina e casa residência, esta última voltada ao atendimento daqueles que perderam o vínculo familiar. Podem manter suas atividades profissionais e sociais. Oferece tratamento psicológico e médico psiquiátrico, tempo de internamento de 09 meses a 12 meses para dependentes químicos. Não mantém atendimento familiar. Para ingressar na casa o paciente deve passar por uma avaliação clínica e social.\n");
        casa.setTel("(41) 3349-1681");
        casa.setImage(R.drawable.casadoservo);
        casa.setLat(-25.5357107);
        casa.setLng(-49.2884355);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Chácara Jesus Cristo Liberta/Lar Berseba ");
        casa.setAddress("Rua Domingos Fernandes Maia, 346");
        casa.setDescription("Atendimento exclusivamente voluntário e de caráter espiritual. Dispõe de 20 vagas masculinas e 10 femininas, não há custo");
        casa.setTel("(41) 3367-8900 ou (41) 3367-7382");
        casa.setImage(R.drawable.larberseba);
        casa.setLat(-25.4134586);
        casa.setLng(-49.2214948);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Chácara Missão Shalom – Mensageiros do Amor");
        casa.setAddress("Rua Tijucas, 115 - Vila Sam Tiago  - Piraquara");
        casa.setDescription("Internamento exclusivamente voluntário, não utilizam travas ou trancas. Dispõe de 24 vagas masculinas com idades a partir dos 20 anos. \n");
        casa.setTel("(41) 3589-2029");
        casa.setImage(R.drawable.mensageirosdoamor);
        casa.setLat(-25.4676425);
        casa.setLng(-49.0639075);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Centro de Recuperação Nova Esperança – CERENE");
        casa.setAddress("Prolongamento da rua Acre, s/n - Bairro Marafigo - Lapa");
        casa.setDescription("Internamento exclusivamente voluntário, trata-se de uma chácara onde não utilizam trancas, portanto o paciente tem livre acesso à rua. Dispõe de 20 vagas masculinas, optam por um tratamento sem o uso de medicação, salvo casos em que seja imprescindível. Tempo proposto de internamento de 06 meses. ");
        casa.setTel("(41) 3622-8357");
        casa.setImage(R.drawable.cerene);
        casa.setLat(-25.4676425);
        casa.setLng(-49.0639075);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("");
        casa.setAddress("");
        casa.setDescription(" ");
        casa.setTel("");
        casa.setImage(R.drawable.mensageirosdoamor);
        casa.setLat(-26.7997886);
        casa.setLng(-49.1125938);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("");
        casa.setAddress("");
        casa.setDescription(" ");
        casa.setTel("");
        casa.setImage(R.drawable.mensageirosdoamor);
        casa.setLat(-25.4676425);
        casa.setLng(-49.0639075);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("");
        casa.setAddress("");
        casa.setDescription(" ");
        casa.setTel("");
        casa.setImage(R.drawable.mensageirosdoamor);
        casa.setLat(-25.4676425);
        casa.setLng(-49.0639075);
        casas.add(casa);


    }

    private void setRecyclerView() {

        listaCasas.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        listaCasas.setLayoutManager(mLayoutManager);

        CasasAdapter mAdapter = new CasasAdapter(casas);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = listaCasas.getChildLayoutPosition(view);
                mudarTela(casas.get(position));

            }
        });

        listaCasas.setAdapter(mAdapter);
        listaCasas.setItemAnimator(new DefaultItemAnimator());

    }


    private void mudarTela(CasaEntity casa) {
        Intent intent = new Intent(SearchActivity.this, DescriptionActivity.class);
        intent.putExtra("casa", casa);
        startActivity(intent);
    }


}
