/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOInterfaces;

/**
 *
 * @author Eliseo
 */
public interface DAOLogin {

    /**
     *
     * @param us
     * @param psw
     * @return
     * @throws Exception
     */
    public boolean Ingresar(String us, String psw) throws Exception;
}
