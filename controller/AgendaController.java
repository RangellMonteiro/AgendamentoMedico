package controller;

import model.Medico;
import model.Paciente;
import model.Horario;

import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private static AgendaController instance;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    private AgendaController() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();

        // Instanciando médicos e adicionando horários
        adicionarMedico("Dr. Silva", "11111111111", "Cardiologia", 300);
        adicionarMedico("Dr. Costa", "22222222222", "Dermatologia", 250);
        adicionarMedico("Dr. Oliveira", "33333333333", "Ortopedia", 200);
        adicionarMedico("Dr. Santos", "44444444444", "Pediatria", 150);
        adicionarMedico("Dr. Ferreira", "55555555555", "Ginecologia", 180);

        // Instanciando pacientes
        adicionarPaciente("João", "12345678900");
        adicionarPaciente("Maria", "98765432100");
        adicionarPaciente("Carlos", "11223344556");

        // Adicionando horários para os médicos
        adicionarHorarios();
    }

    public static AgendaController getInstance() {
        if (instance == null) {
            instance = new AgendaController();
        }
        return instance;
    }

    // Método para adicionar médicos
    public void adicionarMedico(String nome, String cpf, String especialidade, double valorConsulta) {
        Medico medico = new Medico(nome, cpf, especialidade, valorConsulta);
        medicos.add(medico);
    }

    // Método para adicionar pacientes
    public void adicionarPaciente(String nome, String cpf) {
        Paciente paciente = new Paciente(nome, cpf);
        pacientes.add(paciente);
    }

    // Método para listar médicos
    public List<Medico> listarMedicos() {
        return medicos;
    }

    // Método para listar pacientes
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    // Método para agendar consulta
    public String agendarConsulta(String nomePaciente, String especialidade, String horarioEscolhido,
            String nomeMedico) {
        Medico medico = null;
        for (Medico m : medicos) {
            if (m.getNome().equals(nomeMedico) && m.getEspecialidade().equals(especialidade)) {
                medico = m;
                break;
            }
        }
        if (medico == null) {
            return "Médico não encontrado para a especialidade informada.";
        }

        // Verifica se o horário está disponível
        for (Horario horario : medico.getHorarios()) {
            if (horario.getHora().equals(horarioEscolhido) && !horario.isOcupado()) {
                medico.marcarHorario(horarioEscolhido); // Marca o horário como ocupado
                return "Consulta agendada com sucesso para " + nomePaciente + " com " + nomeMedico + " às "
                        + horarioEscolhido + ".";
            }
        }
        return "Horário indisponível.";
    }

    // Método para cancelar agendamento
    public String cancelarAgendamento(String nomePaciente, String nomeMedico, String horarioEscolhido) {
        Medico medico = null;
        for (Medico m : medicos) {
            if (m.getNome().equals(nomeMedico)) {
                medico = m;
                break;
            }
        }
        if (medico == null) {
            return "Médico não encontrado.";
        }

        // Verifica se o horário foi agendado e se o paciente é o correto
        for (Horario horario : medico.getHorarios()) {
            if (horario.getHora().equals(horarioEscolhido) && horario.isOcupado()) {
                horario.setOcupado(false);
                return "Agendamento cancelado para o paciente " + nomePaciente + " no horário " + horarioEscolhido
                        + ".";
            }
        }

        return "Horário não encontrado ou já está disponível.";
    }

    // Método para adicionar horários aos médicos
    private void adicionarHorarios() {
        for (Medico medico : medicos) {
            medico.adicionarHorario("08:00");
            medico.adicionarHorario("09:00");
            medico.adicionarHorario("10:00");
            medico.adicionarHorario("11:00");
            medico.adicionarHorario("14:00");
            medico.adicionarHorario("15:00");
            medico.adicionarHorario("16:00");
        }
    }
}
