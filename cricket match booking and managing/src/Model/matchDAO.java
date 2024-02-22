package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Resourse.Match;

public class matchDAO {
    PreparedStatement upname, upDate, upplace, addm, m_id, cancelm, ticdetail;
    String query;

    public matchDAO() {
        try {
            addm = getDBConnection.con.prepareStatement("insert into matches(ground_id,match_name,date) values(?,?,?)");
            m_id = getDBConnection.con
                    .prepareStatement(" select match_id from matches where match_name=? AND date like ?");
            query = "select * from matches";
            upname = getDBConnection.con.prepareStatement("update matches set match_name =? where match_id=?");
            upDate = getDBConnection.con.prepareStatement("update matches set date=? where match_id=?");
            upplace = getDBConnection.con.prepareStatement("update matches set ground_id =? where match_id=?");
            cancelm = getDBConnection.con.prepareStatement("delete from mathes where match_id=?");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int addcricMatch(Match m, String input) {
        int rs = 0;
        try {

            addm.setInt(1, m.getGround_id());
            addm.setString(2, m.getMatch());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date pa = simpleDateFormat.parse(input);
            java.sql.Date da = new java.sql.Date(pa.getTime());
            addm.setDate(3, da);
            rs = addm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int getmatchId(Match m, String input) {
        int key = 0;
        try {

            m_id.setString(1, m.getMatch());
            m_id.setString(2, input);
            ResultSet rs = m_id.executeQuery();
            if (rs.next()) {
                key = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;

    }

    public List<List<String>> GetAllMatch() {
        List<List<String>> d = new ArrayList<>();
        try {
            ResultSet rs = getDBConnection.st.executeQuery(query);
            while (rs.next()) {
                String h = "";
                List<String> li = new ArrayList<>();
                li.add(String.valueOf(rs.getInt(1)));
                li.add(String.valueOf(rs.getInt(2)));
                li.add(rs.getString(3));
                h = h + rs.getDate(4);
                li.add(h);
                d.add(li);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;

    }

    public int updatematchname(Match m, int id) {
        int rs = 0;
        try {
            upname.setString(1, m.getMatch());
            upname.setInt(2, id);
            rs = upname.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int updateDateMatch(Match m, int id) {
        int rs = 0;
        try {
            upDate.setDate(1, m.getMatchDate());
            upDate.setInt(2, id);
            rs = upDate.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int updateplaceMatch(Match m, int id) {
        int rs = 0;
        try {
            upplace.setInt(1, m.getGround_id());
            upplace.setInt(2, id);
            rs = upDate.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return rs;
    }

    public int cancelmatch(int id) {

        int rs = 0;
        try {
            cancelm.setInt(1, id);
            rs = cancelm.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return rs;

    }

}
