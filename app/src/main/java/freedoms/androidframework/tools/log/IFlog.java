package freedoms.androidframework.tools.log;

/**
 * @interface IFlog
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/
public interface IFlog {

	void debug(String string);

	void error(String string);

	void info(String string);

	void verbose(String string);

	void warn(String string);
}
