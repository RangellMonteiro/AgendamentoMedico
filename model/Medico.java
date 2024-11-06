package model;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String cpf;
    private String especialidade;
    private double valorConsulta;
    private List<Horario> horarios;

    public Medico(String nome, String cpf, String especialidade, double valorConsulta) {
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.valorConsulta = valorConsulta;
        this.horarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void adicionarHorario(String hora) {
        horarios.add(new Horario(hora, false)); // Adiciona horário disponível
    }

    public void marcarHorario(String hora) {
        for (Horario horario : horarios) {
            if (horario.getHora().equals(hora)) {
                horario.setOcupado(true);
                break;
            }
        }
    }

    public void listarHorariosDisponiveis() {
        for (Horario horario : horarios) {
            if (!horario.isOcupado()) {
                System.out.println(horario.getHora());
            }
        }
    }
}
