//package be.thomasmore.DungeonsAndDragonsedgeservice.mappers;
//
//import be.thomasmore.DungeonsAndDragonsedgeservice.models.Player;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PlayerRowMapper implements RowMapper<Player> {
//
//    @Override
//    public Player mapRow(ResultSet rs, int arg1) throws SQLException {
//
//        Player player = new Player();
//
//        player.setFirstname(rs.getString("username"));
//        player.setFirstname(rs.getString("firstname"));
//        player.setLastname(rs.getString("lastname"));
//        player.setEmail(rs.getString("email"));
//        player.setPassword(rs.getString("password"));
//        player.setId(rs.getInt("id"));
//
//        return player;
//    }
//}
