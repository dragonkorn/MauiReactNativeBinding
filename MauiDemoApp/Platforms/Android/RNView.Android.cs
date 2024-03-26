using Microsoft.Maui.Handlers;
using Binding = Com.Example.Testlib.Binding;

namespace MauiDemoApp
{
    public class RNView: View
  {
  }

  public partial class RNViewHandler : ViewHandler<RNView, Android.Views.View>
  {
    public static IPropertyMapper<RNView, RNViewHandler> PropertyMapper = new PropertyMapper<RNView, RNViewHandler>(ViewHandler.ViewMapper)
    {
    };

    public RNViewHandler() : base(PropertyMapper)
    {
    }

    public RNViewHandler(IPropertyMapper mapper, CommandMapper commandMapper = null)
        : base(mapper, commandMapper) { }

    protected override Android.Views.View CreatePlatformView()
    {
        var view = (new Binding()).GetReactNativeView(MainActivity.instance);
        // var view = (new Binding()).CreateHelloWorldView(MainActivity.instance);
        // var view = (new Binding()).CreateViewFromAppCompat(MainActivity.instance);
        return view;
    }

    protected override void ConnectHandler(Android.Views.View platformView)
    {
        base.ConnectHandler(platformView);
    }

    protected override void DisconnectHandler(Android.Views.View platformView)
    {
        platformView.Dispose();
        base.DisconnectHandler(platformView);
    }
  }
}