import java.util.*;
import java.io.*;

public class jtrc implements org{
  private final String org_name = "JRTC";
  private String org_service;
  private mediator_org m_org;

  public jtrc(String org_service)
  {
    this.org_service = org_service;
  }

  public void set_mediator(mediator_org mo){
    m_org = mo;
  }

  @Override
  public void request(String service){
    m_org.request(this , service);
  }

  @Override
  public void serve(){
    m_org.serve(this);
  }

  public String get_name(){
    return org_name;
  }

  public String get_service(){
    return org_service;
  }

}
