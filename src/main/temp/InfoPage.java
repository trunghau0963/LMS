<<<<<<<< HEAD:src/main/java/com/lms/accountCRUD/form/InfoPage.java
package com.lms.accountCRUD.form;
========
package com.lms.UserCRUD.form;
>>>>>>>> origin/dev:src/main/temp/InfoPage.java

import java.awt.CardLayout;

import javax.swing.*;

<<<<<<<< HEAD:src/main/java/com/lms/accountCRUD/form/InfoPage.java
import com.lms.accountCRUD.form.other.ViewInformation;
import com.lms.accountCRUD.form.other.temp.EditAccount;
========
import com.lms.UserCRUD.form.other.ViewInformation;
import com.lms.UserCRUD.form.other.temp.EditAccount;
>>>>>>>> origin/dev:src/main/temp/InfoPage.java

public class InfoPage extends JPanel {
  private CardLayout cardLayout;
  EditAccount editAccount;
  ViewInformation viewInformation;

  public InfoPage() {
    super();
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    viewInformation = new ViewInformation(cardLayout, this);
    editAccount = new EditAccount(cardLayout, this);
    
    add(viewInformation, "viewInformation");
    add(editAccount, "editAccount");

  }

}
