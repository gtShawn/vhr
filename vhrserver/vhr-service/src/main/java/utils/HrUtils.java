package utils;

import com.shawn.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author :shawn
 * @create :2020-07-15 10:56:00
 */
public class HrUtils {
    public static Hr getCurrentHr()
    {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
