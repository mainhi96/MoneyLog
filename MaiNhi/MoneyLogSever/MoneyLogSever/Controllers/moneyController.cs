using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace MoneyLogSever.Controllers
{
    public class moneyController : ApiController
    {

        public List<money> GetList()
        {
            DBMoneyDataContext db = new DBMoneyDataContext();
            return db.moneys.ToList();
        }

        public money GettLog(int id)
        {
            DBMoneyDataContext db = new DBMoneyDataContext();
            return db.moneys.FirstOrDefault(x =>x.id ==id);

        }

        public bool PostLog(DateTime date, string content, decimal money1, string category, string note)
        {
            try
            {
                DBMoneyDataContext db = new DBMoneyDataContext();
                money log = new money();
                log.date = date;
                log.content = content;
                log.money1 = money1;
                log.category = category;
                log.note = note;
                db.moneys.InsertOnSubmit(log);
                db.SubmitChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool PutLog(int id, DateTime date, string content, decimal money1, string category, string note)
        {
            try
            {
                DBMoneyDataContext db = new DBMoneyDataContext();
                money log = db.moneys.FirstOrDefault(x => x.id == id);
                if (log == null) return false;
                log.date = date;
                log.content = content;
                log.money1 = money1;
                log.category = category;
                log.note = note;
                db.SubmitChanges();
                return true;

            }
            catch
            {
                return false;
            }
        }

        public bool DeleteLog(int id)
        {

            DBMoneyDataContext db = new DBMoneyDataContext();
            money log = db.moneys.FirstOrDefault(x => x.id == id);
            if (log == null) return false;
            db.moneys.DeleteOnSubmit(log);
            db.SubmitChanges();
            return true;


        }

    }
    
}
