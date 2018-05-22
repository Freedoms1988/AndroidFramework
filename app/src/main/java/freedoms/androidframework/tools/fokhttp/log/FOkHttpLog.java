package freedoms.androidframework.tools.fokhttp.log;

/**
 * Created by freedoms on 2017/3/23.
 */

public class FOkHttpLog implements IFOkHttpLog{

	private static FOkHttpLog instance;

	public static FOkHttpLog getInstance(){
		if(instance==null){
			synchronized (FOkHttpLog.class){
				instance=new FOkHttpLog();
			}
		}
		return instance;
	}
}
