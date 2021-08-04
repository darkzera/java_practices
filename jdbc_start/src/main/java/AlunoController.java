
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoController {
    // Consultas
    public List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();
        try (Connection db = ConnectionJDB.getConnection()){
            PreparedStatement pAlunos = db.prepareStatement("select * from aluno");
            ResultSet rst = pAlunos.executeQuery();
//            alunos.add(new Aluno("baba", 11, "MG"));

//            while (rst.next()){
//                System.out.println("eu");
//                alunos.add(new Aluno(
//                        rst.getString("nome"),
//                        rst.getInt("idade"),
//                        rst.getString("estado")
//                        ));
//            }
            System.out.println(alunos.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alunos;
    }


    public Aluno findById(int id){
        Aluno alunoEncontrado = null;
        String sqlToPerform = "select * from aluno where id = ?";

        try (Connection db = ConnectionJDB.getConnection()){
           ResultSet rst = db.prepareStatement(sqlToPerform).executeQuery();
           if (rst.next()){
//               alunoEncontrado = new Aluno(
//                       rst.getString("nome"),
//                       rst.getInt("idade"),
//                       rst.getString("estado")
//               );
           }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return alunoEncontrado;
    }
}
