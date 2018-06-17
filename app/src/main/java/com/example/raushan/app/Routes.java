package com.example.raushan.app;

/**
 * Created by Raushan on 5/22/2017.
 */

public class Routes {
    private int rtid;
    private String rtno;
    private String rtsrc;
    private String rtdst;
    private String rtpk1;
    private String rtpk2;

    public void setrtid(int rtid)
    {
        this.rtid = rtid;
    }
    public int getrtid()
    {
        return rtid;
    }
    public void setrtno(String rtno)
    {
        this.rtno = rtno;
    }
    public String getrtno()
    {
        return rtno;
    }
    public void setrtsrc(String rtsrc)
    {
        this.rtsrc = rtsrc;
    }
    public String getrtsrc()
    {
        return rtsrc;
    }
    public void setrtdst(String rtdst)
    {
        this.rtdst = rtdst;
    }
    public String getrtdst()
    {
        return rtdst;
    }
    public void setrtpk1(String rtpk1)
    {
        this.rtpk1 = rtpk1;
    }
    public String getrtpk1()
    {
        return rtpk1;
    }
    public void setrtpk2(String rtpk2)
    {
        this.rtpk2 = rtpk2;
    }
    public String getrtpk2()
    {
        return rtpk2;
    }
    public Routes()
    {

    }
    public Routes(String  rtno,String rtsrc,String rtdst,String rtpk1,String rtpk2)
    {
        this.rtno  = rtno;
        this.rtsrc  = rtsrc;
        this.rtdst  = rtdst;
        this.rtpk1  = rtpk1;
        this.rtpk2  = rtpk2;
    }
    public String getString()
    {
        return rtno;
    }

}
