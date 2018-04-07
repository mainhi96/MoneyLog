using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace MoneyLogSever
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            config.MapHttpAttributeRoutes();

            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{id}",// VD: api/moneyController/lay dong co id la 3
                defaults: new { id = RouteParameter.Optional }
            );
        }
    }
}
